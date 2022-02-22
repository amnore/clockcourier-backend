# CI/CD 配置

以后端项目 [lmcc-backend](http://172.29.4.49/191250208_clock_courier/backend-clockcourier) 为例.

有四方需要连接:

- Gitlab Spring Project, 在内网 gitlab 上.
- Jenkins Server, 在 zzh 服务器上.
- Git.nju.edu.cn, [代码托管平台](https://git.nju.edu.cn/).
- Agent Node, 在 hwd 服务器上.

各自的任务:

- 内网 gitlab 负责存储代码便于检查.
- git.nju.edu.cn 负责内外网的连通.
- zzh 服务器负责运行 Jenkins Server 上的两个流水线.
- hwd 服务器负责具体流水线任务执行, 并将测试后的包部署在本服务器.

## 期望的 CI/CD 流程

- 用户向内网仓库提交代码, 触发 Gitlab Webhook.
- Gitlab Webhook 通知 Jenkins Server, 开始执行流水线脚本.
- Jenkins Server 将任务分配给 Agent Node, 拉取代码并进行构建测试部署.

## 连接配置

### Gitlab -> Git.nju -> Jenkins

由于内网 gitlab 无法直接被外网服务器访问, 所以需要把 gitlab 仓库镜像托管到 git.nju.edu.cn.

> 镜像托管的 url 格式: https://username@git.nju.edu.cn/username/project-name, 密码填 git.nju.edu.cn 密码.

相应地, 具体 Gitlab Integration 的相关配置就需要在 git.nju.edu.cn 对应镜像仓库做.

只需要按照要求填入 Jenkins Server url 和用户名密码就可以了.

### Jenkins -> Git.nju -> Gitlab

之前陷入了误区: 必须要让 Jenkins 连接上 git.nju.edu.cn, 然而它并没有开放 443 端口, 所以一直不行.

后来发现 git.nju.edu.cn 开放 22 端口, 可以用 ssh 进行 clone, 所以事情就简单了起来:

- 通过 ssh 将项目拉到 jenkins 的工作目录, 注意它在 agent 物理机上.
- 而后执行一系列命令.

