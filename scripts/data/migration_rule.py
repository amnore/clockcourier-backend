import pymongo
import csv
import pandas as pd

# 读取csv并建立map
ruleSupport = pd.read_csv('rs.csv')
rules = ruleSupport.values.tolist()
ruleMap = dict()
flag = 0

for rule in rules:
    from_id = str(rule[0])
    # print(group_id)
    to_id = str(rule[1])
    # print(artifact_id)
    key = from_id + ':' + to_id
    # print(key)
    ruleMap[key] = rule[2]

distanceSupport = pd.read_csv('ds.csv')
distances = distanceSupport.values.tolist()

messageSupport = pd.read_csv('ms.csv')
messages = messageSupport.values.tolist()
messageMap = dict()

for message in messages:
    from_id = str(message[0])
    # print(group_id)
    to_id = str(message[1])
    # print(artifact_id)
    key = from_id + ':' + to_id
    # print(key)
    messageMap[key] = message[2]

apiSupport = pd.read_csv('as.csv')
apis = apiSupport.values.tolist()
apiMap = dict()

for api in apis:
    from_id = str(api[0])
    # print(group_id)
    to_id = str(api[1])
    # print(artifact_id)
    key = from_id + ':' + to_id
    # print(key)
    apiMap[key] = api[2]

data = []
cur = 0
# 组合所有指标 生成 migrationRule
for distance in distances:
    from_id = str(distance[0])
    # print(group_id)
    to_id = str(distance[1])
    # print(artifact_id)
    key = from_id + ':' + to_id
    curRS = ruleMap.get(key)
    curMS = messageMap.get(key)
    curDS = distance[2]
    curAS = apiMap.get(key)
    if not curRS:
        curRS = 0
    if not curMS:
        curMS = 0
    if not curDS:
        curDS = 0
    if not curAS:
        curAS = 0.1
    if curAS < 0.1:
        curAS = 0.1
    confidence = curRS * curMS * curDS * curAS
    data.append([int(float(from_id)), int(float(to_id)), confidence, curRS, curMS, curDS, curAS])
    cur += 1
    if cur % 100000 == 0:
        print("现在在处理第", cur, "条实例")
        if flag == 0:
            flag = 1
            df = pd.DataFrame(data)
            df.columns = ["from_Id", "to_Id", "confidence", "rule_sup", "msg_sup", "dis_sup", "api_sup"]
            df.to_csv("migration_rules.csv", encoding='utf-8', index=False)
            data = []
        else:
            df = pd.DataFrame(data)
            df.to_csv('migration_rules.csv', encoding='utf-8', mode='a', header=False, index=False)
            data = []

df = pd.DataFrame(data)
df.to_csv('migration_rules.csv', encoding='utf-8', mode='a', header=False, index=False)
