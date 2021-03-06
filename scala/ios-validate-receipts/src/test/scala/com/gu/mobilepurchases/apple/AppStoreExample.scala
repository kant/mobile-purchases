package com.gu.mobilepurchases.apple

import com.gu.mobilepurchases.shared.external.Jackson

import scala.io.Source

object AppStoreExample {
  val success: AppStoreExample = new AppStoreExample("success-prod")

  def successAsAppStoreResponse: AppStoreResponse = Jackson.mapper.readValue[AppStoreResponse](success.responseString)
  def appStoreResponseExample = AppStoreResponse("", None, None, None, None, None)
  def appStoreResponseReceiptExample = AppStoreResponseReceipt(
    Some(""), "", Some(""), Some(""), Some(""))
}

class AppStoreExample(folderName: String) {
  def responseString: String = Source.fromResource(s"apple/example/$folderName/response.json").mkString
}
