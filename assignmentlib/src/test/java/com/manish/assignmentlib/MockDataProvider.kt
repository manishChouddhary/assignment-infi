package com.manish.assignmentlib

import com.google.gson.Gson
import com.manish.assignmentlib.model.Facts
import java.lang.Exception

class MockDataProvider {
    companion object {
        const val page_title ="About Canada"
        const val imageHref = "http://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/American_Beaver.jpg/220px-American_Beaver.jpg"
        const val title = "Beavers"
        const val description = "Beavers are second only to humans in their ability to manipulate and change their environment. They can measure up to 1.3 metres long. A group of beavers is called a colony"

        fun getMockFactsResponse(): Facts {
            return Gson().fromJson(getFactResponse(), Facts::class.java)
        }

        fun getMockErrorResponse(){
            throw Exception()
        }

        fun getFactResponse(): String {
            return """{
"title":"About Canada",
"rows":[
	{
	"title":"Beavers",
	"description":"Beavers are second only to humans in their ability to manipulate and change their environment. They can measure up to 1.3 metres long. A group of beavers is called a colony",
	"imageHref":"http://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/American_Beaver.jpg/220px-American_Beaver.jpg"
	}
]
}"""
        }
    }
}