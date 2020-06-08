package org.devops

//打包流程
def Build(buildType){
  def buildTools = ["mvn":"m3", "npm":"npm"]
  println("当前打包的类型为 ${buildType}")
  if (buildType == "mvn"){
    def buildShell = "-v"
  }else if (buildType == "npm"){
    def buildShell = "-v"
  }else {
    def buildShell = "-unknown"
  }
  buildHome = tool buildTools[buildType]
  sh "${buildHome}/bin/${buildType} ${buildShell}"
}