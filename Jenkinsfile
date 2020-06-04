#!groovy

// load share lib
@Library('shareLib') _
def tools = new org.devops.tool

String workspace = "/opt/jenkins/workspace"
//Pipeline
pipeline {
    agent { node {  label "master"   //指定运行节点的标签或者名称
                    customWorkspace "${workspace}"   //指定运行工作目录（可选）
            }
    }

    options {
        timestamps()  //日志会有时间 需要安装timestamper插件
        skipDefaultCheckout()  //删除隐式checkout scm语句
        disableConcurrentBuilds() //禁止并行
        timeout(time: 1, unit: 'HOURS')  //流水线超时设置1h
    }

    stages {
        //下载代码
        stage("GetCode"){ //阶段名称
            steps{  //步骤
                timeout(time:20, unit:"MINUTES"){   //步骤超时时间
                    script{
                        println('获取代码')
                    }
                }
            }
        }

        stage("Build"){ //阶段名称
            steps{  //步骤
                timeout(time:20, unit:"MINUTES"){   //步骤超时时间
                    script{
                        println('应用打包')
                    }
                }
            }
        }

                //代码扫描
                stage("CodeScan"){
                    steps{
                        timeout(time:30, unit:"MINUTES"){
                            script{
                                println("代码扫描")
                            }
                        }
                    }
                }
            }



    //构建后操作
    post {
        always {
            script{
                println("always")
                tools.printMessage("call shareLib success !!!")
            }
        }

        success {
            script{
                currentBuild.description = "\n 构建成功!"
            }
        }

        failure {
            script{
                currentBuild.description = "\n 构建失败!"
            }
        }

        aborted {
            script{
                currentBuild.description = "\n 构建取消!"
            }
        }
    }
}
