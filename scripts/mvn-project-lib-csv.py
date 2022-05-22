import pandas as pd
import numpy as np

data_mediator_path = "/home/xiayi/Mine/code/workspace/se3/tmp/data-mediator"
lio_repository_path = data_mediator_path + "/lioRepository"
lio_project_path = data_mediator_path + "/lioProject"


def process_project():
    data = pd.read_csv(lio_repository_path, encoding='utf-8')
    data['url'] = "https://github.com/" + data['nameWithOwner']
    data = data.drop(['homepageURL'], axis=1)
    data.to_csv('mvn_project.csv', index=False, encoding='utf-8')


def clean(s: str):
    if isinstance(s, float) and np.isnan(s):
        return s
    elif isinstance(s, int) or isinstance(s, float):
        return str(s).strip()
    elif isinstance(s, str):
        return s.strip()
    return s


def warp(s: str):
    print(s)
    if str(s) == 'nan':
        return ''
    return "'" + str(s) + "'"


def process_lib():
    data = pd.read_csv(lio_project_path, encoding='utf-8')
    data['groupId'] = data['name'].apply(lambda x: x.split(':')[0])
    data['artifactId'] = data['name'].apply(lambda x: x.split(':')[1])
    data['mvnCtrUrl'] = "https://mvnrepository.com/artifact/" + \
        data["groupId"] + "/" + data["artifactId"]
    data = data.drop(['name'], axis=1)
    columns = ['groupId', 'artifactId',
               'mvnCtrUrl', 'repositoryUrl', 'description']
    data = data[columns]
    # data[columns[0]] = data[columns[0]].map(warp)
    for column in columns:
        data[column] = data[column].map(clean)
    data.to_csv('mvn_lib.csv', index=False, encoding='utf-8')


# 数据导入直接用 shell 做, 这里处理 csv
if __name__ == "__main__":
    print("process lib")
    process_lib()
    print("process project")
    # process_project()
