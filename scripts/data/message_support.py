import pymongo
import csv
import pandas as pd
import math

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

# 要转化为csv的数据
data = []
mcr = mc.find()

for x in mcr:

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

    mc = len(x['possibleCommitList'])
    ms = math.log(mc + 1, 2)

    data.append([fromId, toId, ms])
    # print([fromId,toId,ms])

    cur += 1
    if cur % 100 == 0:
        print("现在在处理第", cur, "条实例")

df = pd.DataFrame(data)
df.columns = ["fromId", "toId", "ms"]
df.to_csv("ms.csv", encoding='utf-8', index=False)
