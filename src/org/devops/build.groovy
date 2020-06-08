package org.devops

//打包流程
def Build(buildType, buildShell){
  def buildTools = ["mvn":"m3", "npm":"npm"]
  println("当前打包的类型为 ${buildType}")
  buildHome = tool buildTools[buildType]
  sh "${buildHome}/bin/${buildType} ${buildShell}"
}