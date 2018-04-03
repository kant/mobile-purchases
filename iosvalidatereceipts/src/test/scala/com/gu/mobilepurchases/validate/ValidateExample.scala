package com.gu.mobilepurchases.validate

import scala.io.Source

object ValidateExample {
  val successExample: ValidateExample = new ValidateExample("success")
  val successProdValidatedTransaction: ValidatedTransaction = ValidatedTransaction(
    "1000000385437274",
    validated = true,
    finishTransaction = true,
    ValidatedTransactionPurchase("uk.co.guardian.gce.plusobserver.1monthsub", "20000001746150", ValidatedTransactionPurchaseActiveInterval(
      "2012-09-30T12:24:36.000Z", "2012-11-06T13:24:36.000Z")), 0)

  val successValidateRequestTransaction: ValidateRequestTransaction = ValidateRequestTransaction(
    "1000000385437274",
    "ewoJInNpZ25hdHVyZSIgPSAiQTNCMDkwWU1vOTJDZTUxOGZNRVpnSjAzdlBObHRBdGFyR3NhK2RkODBZQzNKOEp3WkN4ZTlGeVM2cmQ0bnNwd0VVbE5xQWdrbGdOUUEyemZpekZqUVFmenF5RWY3M291WWlNUmVCKzB6MTZHVURBUVJ5MGV4RnJYWjdCVmxSRkFLMlJmemZxeXduVG9lUUJDaE4weU5XVmliWUJPZmpDSVdNNjRpaUx1cDk5SnFZcUgxaFcrcS9DajhneFEvTlFmT0pZdUNTMDhnOE5iNHRYNlZuMDZrTnU2elZ4MlF4S01iYTV6NUpCL3BDbEY2Y3Q0cDVZQURtalpNUDQ5VWgvK0J4b2NrWFRRZC81SHdlSVdnTE8xaHFlWUdSeU1pc3A0My9MRkQrb1ZLRVZPcjhxck1SSGhzTzlUS3k3WWt2dTBsT0dEKzlxdWp1TjF3M0I3U1orckppTUFBQVdBTUlJRmZEQ0NCR1NnQXdJQkFnSUlEdXRYaCtlZUNZMHdEUVlKS29aSWh2Y05BUUVGQlFBd2daWXhDekFKQmdOVkJBWVRBbFZUTVJNd0VRWURWUVFLREFwQmNIQnNaU0JKYm1NdU1Td3dLZ1lEVlFRTERDTkJjSEJzWlNCWGIzSnNaSGRwWkdVZ1JHVjJaV3h2Y0dWeUlGSmxiR0YwYVc5dWN6RkVNRUlHQTFVRUF3dzdRWEJ3YkdVZ1YyOXliR1IzYVdSbElFUmxkbVZzYjNCbGNpQlNaV3hoZEdsdmJuTWdRMlZ5ZEdsbWFXTmhkR2x2YmlCQmRYUm9iM0pwZEhrd0hoY05NVFV4TVRFek1ESXhOVEE1V2hjTk1qTXdNakEzTWpFME9EUTNXakNCaVRFM01EVUdBMVVFQXd3dVRXRmpJRUZ3Y0NCVGRHOXlaU0JoYm1RZ2FWUjFibVZ6SUZOMGIzSmxJRkpsWTJWcGNIUWdVMmxuYm1sdVp6RXNNQ29HQTFVRUN3d2pRWEJ3YkdVZ1YyOXliR1IzYVdSbElFUmxkbVZzYjNCbGNpQlNaV3hoZEdsdmJuTXhFekFSQmdOVkJBb01Da0Z3Y0d4bElFbHVZeTR4Q3pBSkJnTlZCQVlUQWxWVE1JSUJJakFOQmdrcWhraUc5dzBCQVFFRkFBT0NBUThBTUlJQkNnS0NBUUVBcGMrQi9TV2lnVnZXaCswajJqTWNqdUlqd0tYRUpzczl4cC9zU2cxVmh2K2tBdGVYeWpsVWJYMS9zbFFZbmNRc1VuR09aSHVDem9tNlNkWUk1YlNJY2M4L1cwWXV4c1FkdUFPcFdLSUVQaUY0MWR1MzBJNFNqWU5NV3lwb041UEM4cjBleE5LaERFcFlVcXNTNCszZEg1Z1ZrRFV0d3N3U3lvMUlnZmRZZUZScjZJd3hOaDlLQmd4SFZQTTNrTGl5a29sOVg2U0ZTdUhBbk9DNnBMdUNsMlAwSzVQQi9UNXZ5c0gxUEttUFVockFKUXAyRHQ3K21mNy93bXYxVzE2c2MxRkpDRmFKekVPUXpJNkJBdENnbDdaY3NhRnBhWWVRRUdnbUpqbTRIUkJ6c0FwZHhYUFEzM1k3MkMzWmlCN2o3QWZQNG83UTAvb21WWUh2NGdOSkl3SURBUUFCbzRJQjF6Q0NBZE13UHdZSUt3WUJCUVVIQVFFRU16QXhNQzhHQ0NzR0FRVUZCekFCaGlOb2RIUndPaTh2YjJOemNDNWhjSEJzWlM1amIyMHZiMk56Y0RBekxYZDNaSEl3TkRBZEJnTlZIUTRFRmdRVWthU2MvTVIydDUrZ2l2Uk45WTgyWGUwckJJVXdEQVlEVlIwVEFRSC9CQUl3QURBZkJnTlZIU01FR0RBV2dCU0lKeGNKcWJZWVlJdnM2N3IyUjFuRlVsU2p0ekNDQVI0R0ExVWRJQVNDQVJVd2dnRVJNSUlCRFFZS0tvWklodmRqWkFVR0FUQ0IvakNCd3dZSUt3WUJCUVVIQWdJd2diWU1nYk5TWld4cFlXNWpaU0J2YmlCMGFHbHpJR05sY25ScFptbGpZWFJsSUdKNUlHRnVlU0J3WVhKMGVTQmhjM04xYldWeklHRmpZMlZ3ZEdGdVkyVWdiMllnZEdobElIUm9aVzRnWVhCd2JHbGpZV0pzWlNCemRHRnVaR0Z5WkNCMFpYSnRjeUJoYm1RZ1kyOXVaR2wwYVc5dWN5QnZaaUIxYzJVc0lHTmxjblJwWm1sallYUmxJSEJ2YkdsamVTQmhibVFnWTJWeWRHbG1hV05oZEdsdmJpQndjbUZqZEdsalpTQnpkR0YwWlcxbGJuUnpMakEyQmdnckJnRUZCUWNDQVJZcWFIUjBjRG92TDNkM2R5NWhjSEJzWlM1amIyMHZZMlZ5ZEdsbWFXTmhkR1ZoZFhSb2IzSnBkSGt2TUE0R0ExVWREd0VCL3dRRUF3SUhnREFRQmdvcWhraUc5Mk5rQmdzQkJBSUZBREFOQmdrcWhraUc5dzBCQVFVRkFBT0NBUUVBRGFZYjB5NDk0MXNyQjI1Q2xtelQ2SXhETUlKZjRGelJqYjY5RDcwYS9DV1MyNHlGdzRCWjMrUGkxeTRGRkt3TjI3YTQvdncxTG56THJSZHJqbjhmNUhlNXNXZVZ0Qk5lcGhtR2R2aGFJSlhuWTR3UGMvem83Y1lmcnBuNFpVaGNvT0FvT3NBUU55MjVvQVE1SDNPNXlBWDk4dDUvR2lvcWJpc0IvS0FnWE5ucmZTZW1NL2oxbU9DK1JOdXhUR2Y4YmdwUHllSUdxTktYODZlT2ExR2lXb1IxWmRFV0JHTGp3Vi8xQ0tuUGFObVNBTW5CakxQNGpRQmt1bGhnd0h5dmozWEthYmxiS3RZZGFHNllRdlZNcHpjWm04dzdISG9aUS9PamJiOUlZQVlNTnBJcjdONFl0UkhhTFNQUWp2eWdhWndYRzU2QWV6bEhSVEJoTDhjVHFBPT0iOwoJInB1cmNoYXNlLWluZm8iID0gImV3b0pJbTl5YVdkcGJtRnNMWEIxY21Ob1lYTmxMV1JoZEdVdGNITjBJaUE5SUNJeU1ERTNMVEEyTFRJeklEQTFPakl3T2pRMklFRnRaWEpwWTJFdlRHOXpYMEZ1WjJWc1pYTWlPd29KSW1sekxXbHVMV2x1ZEhKdkxXOW1abVZ5TFhCbGNtbHZaQ0lnUFNBaVptRnNjMlVpT3dvSkluQjFjbU5vWVhObExXUmhkR1V0YlhNaUlEMGdJakUxTWpJd05qY3dOak14TURjaU93b0pJblZ1YVhGMVpTMXBaR1Z1ZEdsbWFXVnlJaUE5SUNJME5EYzFNRFJpWkRZMU9UQmhaRE16TURSaVlUVmtZemM0TlROak5HTXpZMlUxT0RrMU1qQmxJanNLQ1NKdmNtbG5hVzVoYkMxMGNtRnVjMkZqZEdsdmJpMXBaQ0lnUFNBaU1UQXdNREF3TURNd09UWTRNalkyTmlJN0Nna2laWGh3YVhKbGN5MWtZWFJsSWlBOUlDSXhOVEl5TURZM016WXpNVEEzSWpzS0NTSjBjbUZ1YzJGamRHbHZiaTFwWkNJZ1BTQWlNVEF3TURBd01ETTROVFF6TnpJM05DSTdDZ2tpY1hWaGJuUnBkSGtpSUQwZ0lqRWlPd29KSW5kbFlpMXZjbVJsY2kxc2FXNWxMV2wwWlcwdGFXUWlJRDBnSWpFd01EQXdNREF3TXpZd01qSTNOamtpT3dvSkltOXlhV2RwYm1Gc0xYQjFjbU5vWVhObExXUmhkR1V0YlhNaUlEMGdJakUwT1RneU1qQTBORFl3TURBaU93b0pJblZ1YVhGMVpTMTJaVzVrYjNJdGFXUmxiblJwWm1sbGNpSWdQU0FpUlRneFJVWkNRVGN0UVRkQlJTMDBNak5ETFVKRFJqSXRRMFF5TVVGRVJEVkJRekk0SWpzS0NTSmxlSEJwY21WekxXUmhkR1V0Wm05eWJXRjBkR1ZrTFhCemRDSWdQU0FpTWpBeE9DMHdNeTB5TmlBd05Ub3lPVG95TXlCQmJXVnlhV05oTDB4dmMxOUJibWRsYkdWeklqc0tDU0pwZEdWdExXbGtJaUE5SUNJNE1qQTVPRFE0TWpVaU93b0pJbVY0Y0dseVpYTXRaR0YwWlMxbWIzSnRZWFIwWldRaUlEMGdJakl3TVRndE1ETXRNallnTVRJNk1qazZNak1nUlhSakwwZE5WQ0k3Q2draWIzSnBaMmx1WVd3dGNIVnlZMmhoYzJVdFpHRjBaU0lnUFNBaU1qQXhOeTB3TmkweU15QXhNam95TURvME5pQkZkR012UjAxVUlqc0tDU0p3Y205a2RXTjBMV2xrSWlBOUlDSjFheTVqYnk1bmRXRnlaR2xoYmk1bmJHRXVNVzF2Ym5Sb0lqc0tDU0p3ZFhKamFHRnpaUzFrWVhSbElpQTlJQ0l5TURFNExUQXpMVEkySURFeU9qSTBPakl6SUVWMFl5OUhUVlFpT3dvSkltbHpMWFJ5YVdGc0xYQmxjbWx2WkNJZ1BTQWlabUZzYzJVaU93b0pJbkIxY21Ob1lYTmxMV1JoZEdVdGNITjBJaUE5SUNJeU1ERTRMVEF6TFRJMklEQTFPakkwT2pJeklFRnRaWEpwWTJFdlRHOXpYMEZ1WjJWc1pYTWlPd29KSW1KcFpDSWdQU0FpZFdzdVkyOHVaM1ZoY21ScFlXNHVhWEJvYjI1bE1pSTdDZ2tpWW5aeWN5SWdQU0FpTVRVM09Ea2lPd3A5IjsKCSJlbnZpcm9ubWVudCIgPSAiU2FuZGJveCI7CgkicG9kIiA9ICIxMDAiOwoJInNpZ25pbmctc3RhdHVzIiA9ICIwIjsKfQ==",
    "purchased")
  val successValidatedTransaction: ValidatedTransaction = ValidatedTransaction(
    "1000000385437274",
    1,
    1,
    ValidatedTransactionPurchase(
      "uk.co.guardian.gla.1month",
      "1000000036022769",
      ValidatedTransactionPurchaseActiveInterval("2018-03-26T12:24:23.107Z", "2018-03-26T12:29:23.107Z")),

    0
  )

}

case class ValidateExample(folderName: String) {
  def requestString: String = Source.fromResource(s"validate/example/$folderName/request.json").mkString

  def responseString: String = Source.fromResource(s"validate/example/$folderName/response.json").mkString
}
