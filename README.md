# AuthMeBEUI
为基岩版玩家添加 AuthMe 登录 UI\
Added AuthMe UI for Bedrock Edition players

![Minecraft Version](https://img.shields.io/badge/Minecraft-1.18~1.19-green) ![GitHub Repo stars](https://img.shields.io/github/stars/klxf/AuthMeBEUI) ![release](https://img.shields.io/github/v/release/klxf/AuthMeBEUI) ![downloads](https://img.shields.io/github/downloads/klxf/AuthMeBEUI/latest/total) [![MCBBS](https://img.shields.io/badge/MCBBS-v4%20Page-green)](https://beta.mcbbs.net/resource/servermod/et7spw1n)

## 关于这个插件
这个插件基于 Floodgate 为 Geyser 互通服的基岩版玩家添加了 AuthMe 插件的登录 UI，使之登录更加方便

## 注意事项
必须的前置插件：Floodgate 和 AuthMe

如果你的服务器使用了 BungeeCord，你需要在子服也安装 Floodgate\
修改 BungeeCord 的 Floodgate 配置文件中的 `send-floodgate-data` 为 `true`，之后**将 `key.pem` 复制到子服的 Floodgate 配置文件目录**

插件暂不支持重载，修改 `config.yml` 后需要重启服务器

