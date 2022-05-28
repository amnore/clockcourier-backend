import pymongo
import csv
import pandas as pd
import math

migRule = pd.read_csv("lmcc_migration_rules.csv")

ruleInstances = pd.read_csv("ruleInstance.csv")

rules = migRule.values.tolist()

instances = ruleInstances.values.tolist()

migRuleMap = dict()

data = []

flag=0

cur=0

for rule in rules:
    id = rule[0]
    from_id = str(int(float(rule[1])))
    to_id = str(int(float(rule[2])))
    key = from_id + ':' + to_id
    migRuleMap[key] = id

for instance in instances:
    if math.isnan(instance[0]):
        continue
    from_id = str(int(float(instance[0])))

    if math.isnan(instance[1]):
        continue
    to_id = str(int(float(instance[1])))

    key = from_id + ':' + to_id
    rule_id = migRuleMap.get(key)
    data.append([int(float(rule_id)), instance[2], instance[3], instance[4], instance[5]])
    cur+=1
    if(cur%100000==0):
        print("现在处理到",cur,"条")
        if(flag==0):
            flag=1
            df = pd.DataFrame(data)
            df.columns = ["ruleId", "projectId", "file_name", "start_commit_link", "end_commit_link"]
            df.to_csv("trueRuleInstance.csv", encoding='utf-8', index=False)
            data=[]
        else:
            df = pd.DataFrame(data)
            df.to_csv("trueRuleInstance.csv", encoding='utf-8', mode='a', header=False, index=False)
            data = []
df = pd.DataFrame(data)
df.to_csv("trueRuleInstance.csv", encoding='utf-8', mode='a', header=False, index=False)
