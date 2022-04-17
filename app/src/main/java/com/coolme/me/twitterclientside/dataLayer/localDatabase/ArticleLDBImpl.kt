package com.coolme.me.twitterclientside.dataLayer.localDatabase

import com.coolme.me.twitterclientside.dataLayer.di.ArticleRealmDB
import com.coolme.me.twitterclientside.dataLayer.model.ArticleRealm
import com.coolme.me.twitterclientside.dataLayer.userInterface.ArticleLDB
import io.realm.Realm
import io.realm.query
import javax.inject.Inject

class ArticleLDBImpl @Inject constructor(
    @ArticleRealmDB private val articleRealmDB: Realm,
                                        ) : ArticleLDB
{
    override fun saveArticle(articleRealm: ArticleRealm)
    {
        println(articleRealmDB.configuration.path)
        articleRealmDB.writeBlocking  {
            val articleRealmNew: ArticleRealm? = this
                .query<ArticleRealm>("_id == $0", articleRealm._id)
                .first().find()
            if(articleRealmNew != null)
            {
                articleRealmNew.title = articleRealm.title
                articleRealmNew.body = articleRealm.body
                articleRealmNew.updatedAt = articleRealm.updatedAt
            }
            else
            {
                this.copyToRealm(articleRealm)
            }
        }
    }
}