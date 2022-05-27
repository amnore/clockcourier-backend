import json
import csv


class Lib:
    def __init__(self, id, group_id, artifact_id):
        self.id = id
        self.gid = group_id
        self.aid = artifact_id


def ruleSuppot(libs, ruleSeqPath):
    rc = {}
    with open(ruleSeqPath, "r") as file:
        line = file.readline()
        while line != "":
            json_obj = json.loads(line)
            seq = json_obj["seq"]
            for commit in seq:
                changes = commit["changes"]
                adds = []
                subs = []
                for change in changes:
                    if change[0] == '+':
                        adds.append(change[1:])
                    else:
                        subs.append(change[1:])
                if len(adds) > 0 and len(subs) > 0:
                    for add in adds:
                        for sub in subs:
                            if not (libs.get(sub) is None) and not (libs.get(add) is None):
                                if rc.get(libs[sub]) is None:
                                    rc[libs[sub]] = {libs[add]: 1}
                                else:
                                    if (rc[libs[sub]].get(libs[add]) is None):
                                        rc[libs[sub]][libs[add]] = 1
                                    else:
                                        rc[libs[sub]][libs[add]] += 1
            line = file.readline()
        pass
    # max rc
    max_rc = {}
    for key in rc.keys():
        max_rc[key] = 0
    for key in rc.keys():
        for key_ in rc[key].keys():
            if rc[key][key_] > max_rc[key]:
                max_rc[key] = rc[key][key_]
    rs = rc.copy()
    for key in rs.keys():
        for key_ in rs[key].keys():
            rs[key][key_] = float(rc[key][key_]) / max_rc[key]
    print(rs)
    return rs


def lib(csvPath):
    libs = {}
    with open(csvPath, encoding="utf-8") as csvfile:
        reader = csv.DictReader(csvfile)
        for row in reader:
            # libs.append(Lib(row["lib_id"],row["group_id"],row["artifact_id"]))
            libs[row["group_id"] + ":" + row["artifact_id"]] = row["lib_id"]
    return libs


if __name__ == "__main__":
    libs = lib(".\\data\\lmcc_mvn_libs.csv")
    print(len(libs))
    rs = ruleSuppot(libs, ".\\data\\wocDepSeq3.json")
    columns = ["from_id", "to_id", "rs"]
    data = []
    for key in rs.keys():
        for key_ in rs[key].keys():
            data.append([key])
            data[len(data) - 1].append(key_)
            data[len(data) - 1].append(rs[key][key_])

    print(data)
    with open("rs.csv", "w", newline="") as f:
        csv_writer = csv.writer(f)
        csv_writer.writerow(columns)
        csv_writer.writerows(data)
