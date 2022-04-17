package com.coolme.me.twitterclientside.dataLayer.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
class ArticleRealm: RealmObject
{
    @PrimaryKey
    var _id : String = ""
    var title: String = ""
    var author: String = ""
    var body: String = ""
    var createdAt : String = ""
    var updatedAt: String = ""

//    fun toJson(): Map<String, Any>
//    {
//        return mapOf(
//            "title" to title,
//            "body" to body,
//            "token" to token,
//                    )
//    }
}