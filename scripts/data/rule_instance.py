import pymongo
import csv
import pandas as pd

# 读取csv
libs = pd.read_csv('lmcc_mvn_libs.csv')
projects = pd.read_csv('lmcc_mvn_projects.csv')

# 创建lib字典
libs = libs.values.tolist()
libsMap = dict()

cur = 0

for lib in libs:
    group_id = str(lib[1])
    # print(group_id)
    artifact_id = str(lib[2])
    # print(artifact_id)
    key = group_id + artifact_id
    # print(key)
    libsMap[key] = lib[0]

# 创建project字典
projects = projects.values.tolist()
projectsMap = dict()

for project in projects:
    name = str(project[1])
    projectsMap[name] = project[0]

# 拼接要用的url
github = "https://github.com/"

# 连接mongoDB
myclient = pymongo.MongoClient('mongodb://localhost:27017/')

# 连接数据库
mydb = myclient["migration_helper"]

# 获取候选迁移规则表
mc = mydb["libraryMigrationCandidate"]

# 获取id对应表
ga = mydb["libraryGroupArtifact"]

# 检测当前是否已创建目标文件
flag=0

# 要转化为csv的数据
data = []
mcr = mc.find()
for x in mcr:
    # 如果可能迁移字段不为空，进行组合
    # 如果没有可能相关的提交，则跳过
    try:
        if x['repoCommitList']:

            # 取出有用的字段
            fromId = x['fromId']
            toId = x['toId']

            # 先根据这两个id去找对应的id，没有就跳过

            # from_lib
            from_lib = ga.find_one({'_id': fromId})

            fromGroupId = str(from_lib.get("groupId"))
            fromArtifactId = str(from_lib.get("artifactId"))

            fromId = libsMap.get(fromGroupId + fromArtifactId)

            # to_lib
            to_lib = ga.find_one({'_id': toId})

            toGroupId = str(to_lib.get("groupId"))
            toArtifactId = str(to_lib.get("artifactId"))

            toId = libsMap.get(toGroupId + toArtifactId)

            commitList = x['repoCommitList']
            # 0:repoName 1:startCommit 2:endCommit 3:fileName
            for commit in commitList:
                repoName = commit[0]
                repoName = repoName.replace('_', '/', 1)
                # print(repoName)
                # 根据repoName查找projectId
                projectId = projectsMap.get(repoName)

                startCommit = commit[1]
                endCommit = commit[2]
                fileName = commit[3]
                # 组合url
                # 先对仓库名进行替换,替换第一个下划线即得到仓库名
                startCommitLink = github + repoName + '/commit/' + startCommit
                endCommitLink = github + repoName + '/commit/' + endCommit
                # print(startCommitLink)
                data.append([fromId, toId, projectId, fileName, startCommitLink, endCommitLink])
                cur+=1
                if cur%100000==0:
                    print("现在在处理第",cur,"条实例")
                    if flag==0:
                        # 如果当前未创建目标文件，则新建目标文件
                        flag=1
                        df = pd.DataFrame(data)
                        df.columns = ["fromId", "toId", "projectId", "fileName", "startCommitLink", "endCommitLink"]
                        df.to_csv("ruleInstance.csv", encoding='utf-8', index=False)
                        data=[]
                    else:
                        # 若当前已创建目标文件，则追加写入
                        df = pd.DataFrame(data)
                        df.to_csv("ruleInstance.csv", encoding='utf-8',mode='a',header=False,index=False)
                        data=[]
    except:
        pass
        continue
        # print(fromId,toId,x['possibleCommitList'][0][0])

df = pd.DataFrame(data)
df.to_csv("ruleInstance.csv", encoding='utf-8',mode='a',header=False,index=False)
