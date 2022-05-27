import pymongo
import csv
import pandas as pd

# 读取csv
api = pd.read_csv('APISupport.csv')
apis = api.values.tolist()

libs = pd.read_csv('lmcc_mvn_libs.csv')
ga = pd.read_csv('GroupArtifact.csv')

# 创建lib字典
libs = libs.values.tolist()
libsMap = dict()

for lib in libs:
    group_id = str(lib[1])
    # print(group_id)
    artifact_id = str(lib[2])
    # print(artifact_id)
    key = group_id + artifact_id
    # print(key)
    libsMap[key] = lib[0]

# 创建groupArtifact字典
gas = ga.values.tolist()
gaMap = dict()

for ga in gas:
    id = ga[0]
    group_id = str(ga[1])
    artifact_id = str(ga[2])
    value = group_id + artifact_id
    gaMap[id] = value

curId = 0
curMaxCount = 0
data = []
for api in apis:
    fromId = api[0]
    toId = api[1]
    counter = api[2]

    # 如果当前api没变就继续
    if curId == fromId:
        data.append([libsMap.get(gaMap.get(fromId)), libsMap.get(gaMap.get(toId)), counter / curMaxCount])
        # print([fromId,toId,counter/curMaxCount])
    # 如果变化，则处理之前的，然后重置
    else:
        curId = fromId
        curMaxCount = counter
        data.append([libsMap.get(gaMap.get(fromId)), libsMap.get(gaMap.get(toId)), counter / curMaxCount])

df = pd.DataFrame(data)
df.columns = ["fromId", "toId", "as"]
df.to_csv("as.csv", encoding='utf-8', index=False)
