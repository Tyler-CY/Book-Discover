package com.example.bookdiscover

/*
Constants for accessing JSON properties
 */
const val JSON_TITLE = "title"
const val JSON_AUTHORS = "authors"
const val JSON_IMAGELINKS = "imageLinks"
const val JSON_THUMBNAIL = "thumbnail"

/**
 * Query Default Values
 */
const val QUERY_MAXRESULTS_DEFAULT = "25"

const val QUERY_STRING = "QUERY_STRING"

const val TEST_JSON_ONE_LINE = "{\"kind\":\"books#volume\",\"id\":\"Qk4rDwAAQBAJ\",\"etag\":\"aFX2nVotMRs\",\"selfLink\":\"https://books.googleapis.com/books/v1/volumes/Qk4rDwAAQBAJ\",\"volumeInfo\":{\"title\":\"How to Build a Car: The Autobiography of the World’s Greatest Formula 1 Designer\",\"authors\":[\"Adrian Newey\"],\"publisher\":\"HarperCollins UK\",\"publishedDate\":\"2017-11-02\",\"description\":\"<p>'Adrian has a unique gift for understanding drivers and racing cars. He is ultra competitive but never forgets to have fun. An immensely likeable man.' Damon Hill</p> <p>The world’s foremost designer in Formula One, Adrian Newey OBE is arguably one of Britain’s greatest engineers and this is his fascinating, powerful memoir.</p> <p>How to Build a Car explores the story of Adrian’s unrivalled 35-year career in Formula One through the prism of the cars he has designed, the drivers he has worked alongside and the races in which he’s been involved.</p> <p>A true engineering genius, even in adolescence Adrian’s thoughts naturally emerged in shape and form – he began sketching his own car designs at the age of 12 and took a welding course in his school summer holidays. From his early career in IndyCar racing and on to his unparalleled success in Formula One, we learn in comprehensive, engaging and highly entertaining detail how a car actually works. Adrian has designed for the likes of Mario Andretti, Nigel Mansell, Alain Prost, Damon Hill, David Coulthard, Mika Hakkinen, Mark Webber and Sebastian Vettel, always with a shark-like purity of purpose: to make the car go faster. And while his career has been marked by unbelievable triumphs, there have also been deep tragedies; most notably Ayrton Senna’s death during his time at Williams in 1994.</p> <p>Beautifully illustrated with never-before-seen drawings, How to Build a Car encapsulates, through Adrian’s remarkable life story, precisely what makes Formula One so thrilling – its potential for the total synchronicity of man and machine, the perfect combination of style, efficiency and speed.</p>\",\"industryIdentifiers\":[{\"type\":\"ISBN_10\",\"identifier\":\"0008196818\"},{\"type\":\"ISBN_13\",\"identifier\":\"9780008196813\"}],\"readingModes\":{\"text\":true,\"image\":false},\"pageCount\":400,\"printedPageCount\":458,\"printType\":\"BOOK\",\"categories\":[\"Sports & Recreation / Motor Sports / General\",\"Biography & Autobiography / Sports\",\"Biography & Autobiography / Personal Memoirs\",\"Technology & Engineering / Drafting & Mechanical Drawing\",\"Design / Industrial\"],\"averageRating\":4,\"ratingsCount\":5,\"maturityRating\":\"NOT_MATURE\",\"allowAnonLogging\":true,\"contentVersion\":\"1.16.13.0.preview.2\",\"panelizationSummary\":{\"containsEpubBubbles\":false,\"containsImageBubbles\":false},\"imageLinks\":{\"smallThumbnail\":\"http://books.google.com/books/publisher/content?id=Qk4rDwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&imgtk=AFLRE72JjGAvCAnMkAYDY5FbZTy5aTZq5TKjz1Ho-x5fmcp9n3Q5egaE0QVKi5lP8CmgN0lnOwUDettwLxYBX6ExcalUtHTjQN7oc0WW-1m6397cTSyFPIq88LJe88q_arJYKfkycPrl&source=gbs_api\",\"thumbnail\":\"http://books.google.com/books/publisher/content?id=Qk4rDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&imgtk=AFLRE70bc6xOLiIePH0qioSwx87fsRSqSwDU1cz0FmqWvVbjHowN1zWfHE5Jct8m18V6o-g__49t6SX58DLU6hLGJZUS7wVDi9xnjKKI5QOPZPQQ-hbazvZ5yRHgBEusewDWqPngMJEr&source=gbs_api\",\"small\":\"http://books.google.com/books/publisher/content?id=Qk4rDwAAQBAJ&printsec=frontcover&img=1&zoom=2&edge=curl&imgtk=AFLRE73rMd7D6odSzbY6eI_rjU_zFZ2rC4aq2AE2A-goZWRO7J_8BAZDsRGWgYjAjtkF0SlzVpsuXCaq6M1-4ZryassGUWXV6-bZ734QcOmdrXmPSUjkOCEckw3ITnQuzUfWU9YLSBTf&source=gbs_api\",\"medium\":\"http://books.google.com/books/publisher/content?id=Qk4rDwAAQBAJ&printsec=frontcover&img=1&zoom=3&edge=curl&imgtk=AFLRE71PMMPJnU23NA7m9HOwKX20VOwm5fiUOSvIS7GmwtyQr1WsoEJxeML3LuLW5iMgkTb_1dVx3uLdKeT851w4h08hPiGXEk5lE5K4dnFJrahLwo_-_skUeezmpTvCbI-lrL45e8Cu&source=gbs_api\",\"large\":\"http://books.google.com/books/publisher/content?id=Qk4rDwAAQBAJ&printsec=frontcover&img=1&zoom=4&edge=curl&imgtk=AFLRE70KVM4kSJHo7pjX0QXs02qtFdC5QGveukl35UAzyFF0v0uSl19u2Tf0zR6exZKH81rh1fj25bGVoFvsHRNM4O7E8zsdNvgNildabllQ6QEGDnjWjPSdORe8mJPHMNS30AUtn1XB&source=gbs_api\",\"extraLarge\":\"http://books.google.com/books/publisher/content?id=Qk4rDwAAQBAJ&printsec=frontcover&img=1&zoom=6&edge=curl&imgtk=AFLRE71ypyInVqyyHuSR5-ZkFQ8tcS8WohtzDZRzSGIR7zpPeFq1VWrWScicyzkKUMzxymVZ_wtemeDF3Fa3Rp7B--bBLYzvSRomklyIYcfMgohnC9Ftkc45zs-hfKmalo9bVpGPmqOn&source=gbs_api\"},\"language\":\"en\",\"previewLink\":\"http://books.google.ca/books?id=Qk4rDwAAQBAJ&hl=&source=gbs_api\",\"infoLink\":\"https://play.google.com/store/books/details?id=Qk4rDwAAQBAJ&source=gbs_api\",\"canonicalVolumeLink\":\"https://play.google.com/store/books/details?id=Qk4rDwAAQBAJ\"},\"layerInfo\":{\"layers\":[{\"layerId\":\"geo\",\"volumeAnnotationsVersion\":\"18\"}]},\"saleInfo\":{\"country\":\"CA\",\"saleability\":\"FOR_SALE\",\"isEbook\":true,\"listPrice\":{\"amount\":11.99,\"currencyCode\":\"CAD\"},\"retailPrice\":{\"amount\":11.99,\"currencyCode\":\"CAD\"},\"buyLink\":\"https://play.google.com/store/books/details?id=Qk4rDwAAQBAJ&rdid=book-Qk4rDwAAQBAJ&rdot=1&source=gbs_api\",\"offers\":[{\"finskyOfferType\":1,\"listPrice\":{\"amountInMicros\":11990000,\"currencyCode\":\"CAD\"},\"retailPrice\":{\"amountInMicros\":11990000,\"currencyCode\":\"CAD\"},\"giftable\":true}]},\"accessInfo\":{\"country\":\"CA\",\"viewability\":\"PARTIAL\",\"embeddable\":true,\"publicDomain\":false,\"textToSpeechPermission\":\"ALLOWED\",\"epub\":{\"isAvailable\":true,\"acsTokenLink\":\"http://books.google.ca/books/download/How_to_Build_a_Car_The_Autobiography_of-sample-epub.acsm?id=Qk4rDwAAQBAJ&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"},\"pdf\":{\"isAvailable\":false},\"webReaderLink\":\"http://play.google.com/books/reader?id=Qk4rDwAAQBAJ&hl=&printsec=frontcover&source=gbs_api\",\"accessViewStatus\":\"SAMPLE\",\"quoteSharingAllowed\":false}}"


const val TEST_JSON = "{  \"kind\": \"books#volume\"," +
        "  \"id\": \"Qk4rDwAAQBAJ\"," +
        "  \"etag\": \"axE4yzuJuTk\"," +
        "  \"selfLink\": \"https://books.googleapis.com/books/v1/volumes/Qk4rDwAAQBAJ\"," +
        "  \"volumeInfo\": {" +
        "    \"title\": \"How to Build a Car: The Autobiography of the World’s Greatest Formula 1 Designer\"," +
        "    \"authors\": [" +
        "      \"Adrian Newey\"" +
        "    ]," +
        "    \"publisher\": \"HarperCollins UK\"," +
        "    \"publishedDate\": \"2017-11-02\"," +
        "    \"description\": \"\\u003cp\\u003e'Adrian has a unique gift for understanding drivers and racing cars. He is ultra competitive but never forgets to have fun. An immensely likeable man.' Damon Hill\\u003c/p\\u003e \\u003cp\\u003eThe world’s foremost designer in Formula One, Adrian Newey OBE is arguably one of Britain’s greatest engineers and this is his fascinating, powerful memoir.\\u003c/p\\u003e \\u003cp\\u003eHow to Build a Car explores the story of Adrian’s unrivalled 35-year career in Formula One through the prism of the cars he has designed, the drivers he has worked alongside and the races in which he’s been involved.\\u003c/p\\u003e \\u003cp\\u003eA true engineering genius, even in adolescence Adrian’s thoughts naturally emerged in shape and form – he began sketching his own car designs at the age of 12 and took a welding course in his school summer holidays. From his early career in IndyCar racing and on to his unparalleled success in Formula One, we learn in comprehensive, engaging and highly entertaining detail how a car actually works. Adrian has designed for the likes of Mario Andretti, Nigel Mansell, Alain Prost, Damon Hill, David Coulthard, Mika Hakkinen, Mark Webber and Sebastian Vettel, always with a shark-like purity of purpose: to make the car go faster. And while his career has been marked by unbelievable triumphs, there have also been deep tragedies; most notably Ayrton Senna’s death during his time at Williams in 1994.\\u003c/p\\u003e \\u003cp\\u003eBeautifully illustrated with never-before-seen drawings, How to Build a Car encapsulates, through Adrian’s remarkable life story, precisely what makes Formula One so thrilling – its potential for the total synchronicity of man and machine, the perfect combination of style, efficiency and speed.\\u003c/p\\u003e\"," +
        "    \"industryIdentifiers\": [" +
        "      {" +
        "        \"type\": \"ISBN_10\"," +
        "        \"identifier\": \"0008196818\"" +
        "      }," +
        "      {" +
        "        \"type\": \"ISBN_13\"," +
        "        \"identifier\": \"9780008196813\"" +
        "      }" +
        "    ]," +
        "    \"readingModes\": {" +
        "      \"text\": true," +
        "      \"image\": false" +
        "    }," +
        "    \"pageCount\": 400," +
        "    \"printedPageCount\": 458," +
        "    \"printType\": \"BOOK\"," +
        "    \"categories\": [" +
        "      \"Sports &amp; Recreation / Motor Sports / General\"," +
        "      \"Biography &amp; Autobiography / Sports\"," +
        "      \"Biography &amp; Autobiography / Personal Memoirs\"," +
        "      \"Technology &amp; Engineering / Drafting &amp; Mechanical Drawing\"," +
        "      \"Design / Industrial\"" +
        "    ]," +
        "    \"averageRating\": 4," +
        "    \"ratingsCount\": 5," +
        "    \"maturityRating\": \"NOT_MATURE\"," +
        "    \"allowAnonLogging\": true," +
        "    \"contentVersion\": \"1.16.13.0.preview.2\"," +
        "    \"panelizationSummary\": {" +
        "      \"containsEpubBubbles\": false," +
        "      \"containsImageBubbles\": false" +
        "    }," +
        "    \"imageLinks\": {" +
        "      \"smallThumbnail\": \"http://books.google.com/books/publisher/content?id=Qk4rDwAAQBAJ&amp;printsec=frontcover&amp;img=1&amp;zoom=5&amp;edge=curl&amp;imgtk=AFLRE71SMOxuVGu_SVy5hoSaZsvBacjShejYjONjtZxiHAGKGil_Oo4cvgYXn2Zhwd9LCDpV2Nzi-67vdCEdYED9JGmpqUW4d2asDg03-La9zcWl4zqrAF2UyHHzR_CH7EoCiknL5iOm&amp;source=gbs_api\"," +
        "      \"thumbnail\": \"http://books.google.com/books/publisher/content?id=Qk4rDwAAQBAJ&amp;printsec=frontcover&amp;img=1&amp;zoom=1&amp;edge=curl&amp;imgtk=AFLRE73PVM79ufXyeaTxneu3ZTpr_4bbCBOmRnq8NqOOkxt1ilTO9kzqYrJKvKvxm_BR2MEF2ZTiDM0SVRwyOG6N678XOMvcGu3Q0eTYVgRwXxoOnfEgU9ezqRq_JvERRB9IrD-35zKH&amp;source=gbs_api\"," +
        "      \"small\": \"http://books.google.com/books/publisher/content?id=Qk4rDwAAQBAJ&amp;printsec=frontcover&amp;img=1&amp;zoom=2&amp;edge=curl&amp;imgtk=AFLRE70epnFIJzKXeiHZ0W1Z23B61T5qs_nucpNEuO51RTRmdFY4MQluDR57H-tqN9f1tNzU4A_R51dlgOHYc4UE4MUTPwLsBz8MzyZKRMPPz7meKnhMCO4IwsAFbBedGj9A_L0aPxMo&amp;source=gbs_api\"," +
        "      \"medium\": \"http://books.google.com/books/publisher/content?id=Qk4rDwAAQBAJ&amp;printsec=frontcover&amp;img=1&amp;zoom=3&amp;edge=curl&amp;imgtk=AFLRE73arDitLq_OiyK03eYugyOoGNg37_R_YuJrC7yF-BrdzMdvHhMU34FLZRRywmHqhFWEAQ8lVeg_-wO2mSlvoEo9oPsNZ4WYZC1eXnLQKZZ1Vi_cDAP-uFA0G7wPGXubedKy43Md&amp;source=gbs_api\"," +
        "      \"large\": \"http://books.google.com/books/publisher/content?id=Qk4rDwAAQBAJ&amp;printsec=frontcover&amp;img=1&amp;zoom=4&amp;edge=curl&amp;imgtk=AFLRE73Q2PUv9z_exyNX2m4t7xwCw6MZjQO4sWe0tgVeDQ5eT7DhUezzlFFxNlC7qZ2zoFGv1pbV63hGchFlJHiEAlsitqIi68bzfRAaVU9NE9YjM5eDqvQk-ZaJfG6XVuljxxCoCxfw&amp;source=gbs_api\"," +
        "      \"extraLarge\": \"http://books.google.com/books/publisher/content?id=Qk4rDwAAQBAJ&amp;printsec=frontcover&amp;img=1&amp;zoom=6&amp;edge=curl&amp;imgtk=AFLRE73XhMdgWQg2LPce-yQUK3ieEfvTwXzuiHcfT7VnK51-aDg8pl3rXBxvxJktEsq6nPjb2E1J3YTzJvzQ7ynfP7eFNrbQF1svWgyIAVNKoxsuh-2gOXxUIx15WHvtbmlcq7lJz-PO&amp;source=gbs_api\"" +
        "    }," +
        "    \"language\": \"en\"," +
        "    \"previewLink\": \"http://books.google.ca/books?id=Qk4rDwAAQBAJ&amp;hl=&amp;source=gbs_api\"," +
        "    \"infoLink\": \"https://play.google.com/store/books/details?id=Qk4rDwAAQBAJ&amp;source=gbs_api\"," +
        "    \"canonicalVolumeLink\": \"https://play.google.com/store/books/details?id=Qk4rDwAAQBAJ\"" +
        "  }," +
        "  \"layerInfo\": {" +
        "    \"layers\": [" +
        "      {" +
        "        \"layerId\": \"geo\"," +
        "        \"volumeAnnotationsVersion\": \"18\"" +
        "      }" +
        "    ]" +
        "  }," +
        "  \"saleInfo\": {" +
        "    \"country\": \"CA\"," +
        "    \"saleability\": \"FOR_SALE\"," +
        "    \"isEbook\": true," +
        "    \"listPrice\": {" +
        "      \"amount\": 11.99," +
        "      \"currencyCode\": \"CAD\"" +
        "    }," +
        "    \"retailPrice\": {" +
        "      \"amount\": 11.99," +
        "      \"currencyCode\": \"CAD\"" +
        "    }," +
        "    \"buyLink\": \"https://play.google.com/store/books/details?id=Qk4rDwAAQBAJ&amp;rdid=book-Qk4rDwAAQBAJ&amp;rdot=1&amp;source=gbs_api\"," +
        "    \"offers\": [" +
        "      {" +
        "        \"finskyOfferType\": 1," +
        "        \"listPrice\": {" +
        "          \"amountInMicros\": 11990000," +
        "          \"currencyCode\": \"CAD\"" +
        "        }," +
        "        \"retailPrice\": {" +
        "          \"amountInMicros\": 11990000," +
        "          \"currencyCode\": \"CAD\"" +
        "        }," +
        "        \"giftable\": true" +
        "      }" +
        "    ]" +
        "  }," +
        "  \"accessInfo\": {" +
        "    \"country\": \"CA\"," +
        "    \"viewability\": \"PARTIAL\"," +
        "    \"embeddable\": true," +
        "    \"publicDomain\": false," +
        "    \"textToSpeechPermission\": \"ALLOWED\"," +
        "    \"epub\": {" +
        "      \"isAvailable\": true," +
        "      \"acsTokenLink\": \"http://books.google.ca/books/download/How_to_Build_a_Car_The_Autobiography_of-sample-epub.acsm?id=Qk4rDwAAQBAJ&amp;format=epub&amp;output=acs4_fulfillment_token&amp;dl_type=sample&amp;source=gbs_api\"" +
        "    }," +
        "    \"pdf\": {" +
        "      \"isAvailable\": false" +
        "    }," +
        "    \"webReaderLink\": \"http://play.google.com/books/reader?id=Qk4rDwAAQBAJ&amp;hl=&amp;printsec=frontcover&amp;source=gbs_api\"," +
        "    \"accessViewStatus\": \"SAMPLE\"," +
        "    \"quoteSharingAllowed\": false" +
        "  }"