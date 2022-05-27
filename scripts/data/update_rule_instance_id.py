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
    print(int(float(rule_id)), instance[2], instance[3], instance[4], instance[5])

df = pd.DataFrame(data)
df.columns = ["ruleId", "projectId", "file_name", "start_commit_link", "end_commit_link"]
df.to_csv("trueRuleInstance.csv", encoding='utf-8', index=False)
