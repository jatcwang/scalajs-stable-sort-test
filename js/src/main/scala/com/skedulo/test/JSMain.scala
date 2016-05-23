package com.skedulo.test

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.{JSExport, JSExportAll}

object JSMain extends JSApp {

  @scala.scalajs.js.annotation.JSExport
  override def main(): Unit = {
    println("*** Running in JSMain - " + System.getProperty("java.version"))
  }
}
