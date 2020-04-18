package com.manish.assignmentlib.model

data class Facts(val title: String, val rows: List<Fact>)
data class Fact(val title : String?, val description : String?, val imageHref : String?)
