package com.anand

object HttpResponse {

  val responseWithLocation: String =
    """
      |{
      |   "id":"api.org.search",
      |   "ver":"v1",
      |   "ts":"2019-01-08 06:40:12:316+0000",
      |   "params":{
      |      "resmsgid":null,
      |      "msgid":"0f93ff40-582f-4599-a718-7bd898cd8b5d",
      |      "err":null,
      |      "status":"success",
      |      "errmsg":null
      |   },
      |   "responseCode":"OK",
      |   "result":{
      |      "response":{
      |         "count":1,
      |         "content":[
      |            {
      |               "dateTime":null,
      |               "preferredLanguage":"English",
      |               "approvedBy":null,
      |               "channel":"ROOT_ORG",
      |               "description":"Andhra State Boardsssssss",
      |               "updatedDate":"2018-11-28 10:00:08:675+0000",
      |               "addressId":null,
      |               "provider":null,
      |               "locationId":null,
      |               "orgCode":"sunbird",
      |               "theme":null,
      |               "id":"ORG_001",
      |               "communityId":null,
      |               "isApproved":null,
      |               "email":"support_dev@sunbird.org",
      |               "slug":"sunbird",
      |               "identifier":"ORG_001",
      |               "thumbnail":null,
      |               "orgName":"Sunbird",
      |               "updatedBy":"1d7b85b0-3502-4536-a846-d3a51fd0aeea",
      |               "locationIds":[
      |                  "969dd3c1-4e98-4c17-a994-559f2dc70e18"
      |               ],
      |               "externalId":null,
      |               "isRootOrg":true,
      |               "rootOrgId":"ORG_001",
      |               "approvedDate":null,
      |               "imgUrl":null,
      |               "homeUrl":null,
      |               "orgTypeId":null,
      |               "isDefault":true,
      |               "contactDetail":[
      |                  {
      |                     "phone":"213124234234",
      |                     "email":"test@test.com"
      |                  },
      |                  {
      |                     "phone":"+91213124234234",
      |                     "email":"test1@test.com"
      |                  }
      |               ],
      |               "createdDate":null,
      |               "createdBy":null,
      |               "parentOrgId":null,
      |               "hashTagId":"b00bc992ef25f1a9a8d63291e20efc8d",
      |               "noOfMembers":5,
      |               "status":1
      |            }
      |         ]
      |      }
      |   }
      |}
    """.stripMargin

  val responseWithNullLocation: String =
    """
      |{
      |   "id":"api.org.search",
      |   "ver":"v1",
      |   "ts":"2019-01-08 08:57:47:192+0000",
      |   "params":{
      |      "resmsgid":null,
      |      "msgid":"7b1cf31f-0b9f-4d88-b405-4d9c61be8081",
      |      "err":null,
      |      "status":"success",
      |      "errmsg":null
      |   },
      |   "responseCode":"OK",
      |   "result":{
      |      "response":{
      |         "count":1,
      |         "content":[
      |            {
      |               "dateTime":null,
      |               "preferredLanguage":"English",
      |               "approvedBy":null,
      |               "channel":"sunbird-staging",
      |               "description":"default user will be associated with this",
      |               "updatedDate":null,
      |               "addressId":null,
      |               "orgType":null,
      |               "provider":null,
      |               "locationId":null,
      |               "orgCode":"defaultRootOrg",
      |               "theme":null,
      |               "id":"0125134851644620800",
      |               "communityId":null,
      |               "isApproved":null,
      |               "slug":"sunbird-staging",
      |               "identifier":"0125134851644620800",
      |               "thumbnail":null,
      |               "orgName":"defaultRootOrg",
      |               "updatedBy":null,
      |               "locationIds":[
      |
      |               ],
      |               "externalId":null,
      |               "isRootOrg":true,
      |               "rootOrgId":"0125134851644620800",
      |               "approvedDate":null,
      |               "imgUrl":null,
      |               "homeUrl":null,
      |               "orgTypeId":null,
      |               "isDefault":null,
      |               "contactDetail":[
      |
      |               ],
      |               "createdDate":"2018-05-28 16:23:38:330+0000",
      |               "createdBy":"8217108a-6931-491c-9009-1ae95cb0477f",
      |               "parentOrgId":null,
      |               "hashTagId":"0125134851644620800",
      |               "noOfMembers":null,
      |               "status":1
      |            }
      |         ]
      |      }
      |   }
      |}
    """.stripMargin

}
