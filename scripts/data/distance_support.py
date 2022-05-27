#!/bin/python3
import json
from typing import NamedTuple, List, Dict
from sys import stdin
from csv import DictReader


class RepoCommit(NamedTuple):
    repoName: str
    startCommit: str
    endCommit: str
    filePath: str


class Candidate(NamedTuple):
    fromId: int
    toId: int
    repoCommitList: List[RepoCommit]
    commitDistanceList: List[int]


class Lib(NamedTuple):
    groupId: str
    artifactId: str


lib_id: Dict[Lib, int] = {}
with open('lmcc_mvn_libs.csv') as csv:
    reader = DictReader(csv)
    for row in reader:
        lib_id[Lib(groupId=row['group_id'], artifactId=row['artifact_id'])] = int(row['lib_id'])

migration_helper_lib: Dict[int, Lib] = {}
with open('libraryGroupArtifact.json') as f:
    while True:
        line = f.readline()
        if len(line) == 0:
            break

        obj = json.loads(line)
        migration_helper_lib[obj['id']] = Lib(groupId=obj['groupId'], artifactId=obj['artifactId'])

print('from_id,to_id,distance_support')
while True:
    line = stdin.readline()
    if len(line) == 0:
        break

    candidate = json.loads(line, object_hook=lambda d: Candidate(
        fromId=d['fromId'],
        toId=d['toId'],
        repoCommitList=map(lambda c: RepoCommit(**c), d['repoCommitList']),
        commitDistanceList=d['commitDistanceList']
    ))

    sum = 0
    for distance in candidate.commitDistanceList:
        sum += 1 / (1 + distance ** 2)

    distance_support = sum / len(candidate.commitDistanceList)
    convert_id = lambda id: lib_id[migration_helper_lib[id]]
    try:
        print(convert_id(candidate.fromId), convert_id(candidate.toId), distance_support, sep=',')
    except KeyError:  # some artifacts are not present in lioProject
        pass
