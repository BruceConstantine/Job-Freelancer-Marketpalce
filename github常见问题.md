# 版本回退
>
* git clone https://github.com/BruceConstantine/EE4023_JSF.git
* git log --pretty=oneline
    **查看版本号**
```
E.g.
7c0f3f3a04ffced073f7987aeebddf2b1789c2b5 delete all inrelatived files
ae7d7c401a06f6144379c6e4012f7fa75a9745de Delete manifest.mf
2b27dd70d164748ba89028988da9c39fae6258c0 Delete build.xml
98bea2970b5dd2684419fdf9082a3485b5d3d54c Delete lab3bean.rar
b77aee83276acbb82ba9a6299eb594097bad3920 Update README.md
4135f824236bc07c37563395a926ae72c9403e1e Update README.md
87236138d87f456f701a8d3c18878e1d0bc231a7 Update README.md
8a4d2be37aafed0d5186d50abfa40d15df1f9b2f Update README.md
b91d6eb2dda439a89efa928081722cadda09c3cd lin
a4c2b5eaadeb653976b903f1325c53ebbddea070 Update README.md
747038b2061f356798828a24725fc2b810be45c9 Update README.md
04080678c5bd73153f511a35041ca6951d47f3e7 Update README.md
6effa8e0efbfd904e4b8e3715a171b19686e2c74 ihj
e94375bbd808305b2c0463faaa4f7d67131b3b4c ihjn9o
```
*git reset -hard e94375bbd8 (只用输入版本号的前几位就能回到所在的版本了)
**这个是上面的最后一个版本**

# 远程推送

* git clone https://github.com/BruceConstantine/EE4023_JSF.git
* 做点儿改变
* git add *
* git commit -m "...."
* git push origin master
**中间很有可能出错，到时候Google ONE TIME**
