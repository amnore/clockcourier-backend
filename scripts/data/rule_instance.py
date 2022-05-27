import pymongo
import csv
import pandas as pd

github = "https://github.com/"
myclient = pymongo.MongoClient('mongodb://localhost:27017/')
mydb = myclient["migration_helper"]
# 候选迁移规则
mc = mydb["libraryMigrationCandidate"]
# 原表对应
ga = pd.read_csv('ag.csv', index_col=0)

libs = pd.read_csv('lmcc_mvn_libs.csv', index_col=0)
projects = pd.read_csv('lmcc_mvn_projects.csv', index_col=0)

# 查找id
# end=ga.find_one({'_id':5})
# print(end)
cur = 0

data = []
mc
for x in mc.find():
    # 如果可能迁移字段不为空，进行组合

    # 如果没有可能相关的提交，则跳过
    if x['possibleCommitList']:

        # 取出有用的字段
        fromId = x['fromId']
        toId = x['toId']

        # 先根据这两个id去找对应的id，没有就跳过

        # from_lib
        from_lib = ga[ga.index == fromId].values
        # from_lib=ga.find_one({'_id':fromId})
        # print(from_lib)
        # 如果找不到，则跳过
        # if(not from_lib):
        #     continue
        fromGroupId = from_lib[0][0]
        fromArtifactId = from_lib[0][1]

        fromId = libs[(libs["group_id"] == fromGroupId) & (libs["artifact_id"] == fromArtifactId)]
        if fromId.index.to_list():
            fromId = fromId.index.to_list()[0]
        else:
            continue
        # 如果找不到，则跳过
        if not fromId:
            continue

        # print("id1:",from_lib.get('_id'),"Id:",fromId)

        # to_lib
        # to_lib = ga.find_one({'_id': toId})
        to_lib = ga[ga.index == toId].values
        # 如果找不到，则跳过
        # if (not to_lib):
        #     continue
        toGroupId = to_lib[0][0]
        toArtifactId = to_lib[0][1]

        toId = libs[(libs["group_id"] == toGroupId) & (libs["artifact_id"] == toArtifactId)]

        if toId.index.to_list():
            toId = toId.index.to_list()[0]
        else:
            continue
        # 如果找不到，则跳过
        if not toId:
            continue

        # print(fromGroupId)

        # print("id2:", to_lib.get('_id'), "Id:", toId)

        commitList = x['possibleCommitList']
        # 0:repoName 1:startCommit 2:endCommit 3:fileName
        for commit in commitList:
            repoName = commit[0]
            repoName = repoName.replace('_', '/', 1)
            # print(repoName)
            # 根据repoName查找projectId,没有就跳过
            projectId = projects[(projects["name"] == repoName)]
            if projectId.index.to_list():
                projectId = projectId.index.to_list()[0]
            else:
                continue
            # print(projectId)
            startCommit = commit[1]
            endCommit = commit[2]
            fileName = commit[3]
            # 组合url
            # 先对仓库名进行替换,替换第一个下划线即得到仓库名
            startCommitLink = github + repoName + '/commit/' + startCommit
            endCommitLink = github + repoName + '/commit/' + endCommit
            # print(startCommitLink)

            # print([fromId,toId,projectId,fileName,startCommitLink,endCommitLink])
            data.append([fromId, toId, projectId, fileName, startCommitLink, endCommitLink])
            cur += 1
            if cur % 100 == 0:
                print("现在在处理第", cur, "条实例")

        # print(fromId,toId,x['possibleCommitList'][0][0])

df = pd.DataFrame(data)
df.columns = ["fromId", "toId", "projectId", "fileName", "startCommitLink", "endCommitLink"]
df.to_csv("ruleInstance.csv", encoding='utf-8', index=False)
