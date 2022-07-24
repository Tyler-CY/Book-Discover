package com.example.bookdiscover.database

import android.content.Context
import android.content.res.Resources
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.bookdiscover.R
import com.example.bookdiscover.network.Volume

@Database(entities = arrayOf(Bookmarks::class), exportSchema = false, version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun libraryDao(): LibraryDao






    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database")
                    .addCallback(object : Callback(){
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            Thread { prepopulateDb(getDatabase(context)) }.start()
                        }
                    })
                    .build()
                INSTANCE = instance

                instance
            }
        }


        private val CALLBACK = object: RoomDatabase.Callback() {

        }

        private fun prepopulateDb(db: AppDatabase){
//            val bookmark1 = Bookmarks("Qk4rDwAAQBAJ", "{  \"kind\": \"books#volume\",\n" +
//                    "  \"id\": \"Qk4rDwAAQBAJ\",\n" +
//                    "  \"etag\": \"axE4yzuJuTk\",\n" +
//                    "  \"selfLink\": \"https://books.googleapis.com/books/v1/volumes/Qk4rDwAAQBAJ\",\n" +
//                    "  \"volumeInfo\": {\n" +
//                    "    \"title\": \"How to Build a Car: The Autobiography of the World’s Greatest Formula 1 Designer\",\n" +
//                    "    \"authors\": [\n" +
//                    "      \"Adrian Newey\"\n" +
//                    "    ],\n" +
//                    "    \"publisher\": \"HarperCollins UK\",\n" +
//                    "    \"publishedDate\": \"2017-11-02\",\n" +
//                    "    \"description\": \"\\u003cp\\u003e'Adrian has a unique gift for understanding drivers and racing cars. He is ultra competitive but never forgets to have fun. An immensely likeable man.' Damon Hill\\u003c/p\\u003e \\u003cp\\u003eThe world’s foremost designer in Formula One, Adrian Newey OBE is arguably one of Britain’s greatest engineers and this is his fascinating, powerful memoir.\\u003c/p\\u003e \\u003cp\\u003eHow to Build a Car explores the story of Adrian’s unrivalled 35-year career in Formula One through the prism of the cars he has designed, the drivers he has worked alongside and the races in which he’s been involved.\\u003c/p\\u003e \\u003cp\\u003eA true engineering genius, even in adolescence Adrian’s thoughts naturally emerged in shape and form – he began sketching his own car designs at the age of 12 and took a welding course in his school summer holidays. From his early career in IndyCar racing and on to his unparalleled success in Formula One, we learn in comprehensive, engaging and highly entertaining detail how a car actually works. Adrian has designed for the likes of Mario Andretti, Nigel Mansell, Alain Prost, Damon Hill, David Coulthard, Mika Hakkinen, Mark Webber and Sebastian Vettel, always with a shark-like purity of purpose: to make the car go faster. And while his career has been marked by unbelievable triumphs, there have also been deep tragedies; most notably Ayrton Senna’s death during his time at Williams in 1994.\\u003c/p\\u003e \\u003cp\\u003eBeautifully illustrated with never-before-seen drawings, How to Build a Car encapsulates, through Adrian’s remarkable life story, precisely what makes Formula One so thrilling – its potential for the total synchronicity of man and machine, the perfect combination of style, efficiency and speed.\\u003c/p\\u003e\",\n" +
//                    "    \"industryIdentifiers\": [\n" +
//                    "      {\n" +
//                    "        \"type\": \"ISBN_10\",\n" +
//                    "        \"identifier\": \"0008196818\"\n" +
//                    "      },\n" +
//                    "      {\n" +
//                    "        \"type\": \"ISBN_13\",\n" +
//                    "        \"identifier\": \"9780008196813\"\n" +
//                    "      }\n" +
//                    "    ],\n" +
//                    "    \"readingModes\": {\n" +
//                    "      \"text\": true,\n" +
//                    "      \"image\": false\n" +
//                    "    },\n" +
//                    "    \"pageCount\": 400,\n" +
//                    "    \"printedPageCount\": 458,\n" +
//                    "    \"printType\": \"BOOK\",\n" +
//                    "    \"categories\": [\n" +
//                    "      \"Sports &amp; Recreation / Motor Sports / General\",\n" +
//                    "      \"Biography &amp; Autobiography / Sports\",\n" +
//                    "      \"Biography &amp; Autobiography / Personal Memoirs\",\n" +
//                    "      \"Technology &amp; Engineering / Drafting &amp; Mechanical Drawing\",\n" +
//                    "      \"Design / Industrial\"\n" +
//                    "    ],\n" +
//                    "    \"averageRating\": 4,\n" +
//                    "    \"ratingsCount\": 5,\n" +
//                    "    \"maturityRating\": \"NOT_MATURE\",\n" +
//                    "    \"allowAnonLogging\": true,\n" +
//                    "    \"contentVersion\": \"1.16.13.0.preview.2\",\n" +
//                    "    \"panelizationSummary\": {\n" +
//                    "      \"containsEpubBubbles\": false,\n" +
//                    "      \"containsImageBubbles\": false\n" +
//                    "    },\n" +
//                    "    \"imageLinks\": {\n" +
//                    "      \"smallThumbnail\": \"http://books.google.com/books/publisher/content?id=Qk4rDwAAQBAJ&amp;printsec=frontcover&amp;img=1&amp;zoom=5&amp;edge=curl&amp;imgtk=AFLRE71SMOxuVGu_SVy5hoSaZsvBacjShejYjONjtZxiHAGKGil_Oo4cvgYXn2Zhwd9LCDpV2Nzi-67vdCEdYED9JGmpqUW4d2asDg03-La9zcWl4zqrAF2UyHHzR_CH7EoCiknL5iOm&amp;source=gbs_api\",\n" +
//                    "      \"thumbnail\": \"http://books.google.com/books/publisher/content?id=Qk4rDwAAQBAJ&amp;printsec=frontcover&amp;img=1&amp;zoom=1&amp;edge=curl&amp;imgtk=AFLRE73PVM79ufXyeaTxneu3ZTpr_4bbCBOmRnq8NqOOkxt1ilTO9kzqYrJKvKvxm_BR2MEF2ZTiDM0SVRwyOG6N678XOMvcGu3Q0eTYVgRwXxoOnfEgU9ezqRq_JvERRB9IrD-35zKH&amp;source=gbs_api\",\n" +
//                    "      \"small\": \"http://books.google.com/books/publisher/content?id=Qk4rDwAAQBAJ&amp;printsec=frontcover&amp;img=1&amp;zoom=2&amp;edge=curl&amp;imgtk=AFLRE70epnFIJzKXeiHZ0W1Z23B61T5qs_nucpNEuO51RTRmdFY4MQluDR57H-tqN9f1tNzU4A_R51dlgOHYc4UE4MUTPwLsBz8MzyZKRMPPz7meKnhMCO4IwsAFbBedGj9A_L0aPxMo&amp;source=gbs_api\",\n" +
//                    "      \"medium\": \"http://books.google.com/books/publisher/content?id=Qk4rDwAAQBAJ&amp;printsec=frontcover&amp;img=1&amp;zoom=3&amp;edge=curl&amp;imgtk=AFLRE73arDitLq_OiyK03eYugyOoGNg37_R_YuJrC7yF-BrdzMdvHhMU34FLZRRywmHqhFWEAQ8lVeg_-wO2mSlvoEo9oPsNZ4WYZC1eXnLQKZZ1Vi_cDAP-uFA0G7wPGXubedKy43Md&amp;source=gbs_api\",\n" +
//                    "      \"large\": \"http://books.google.com/books/publisher/content?id=Qk4rDwAAQBAJ&amp;printsec=frontcover&amp;img=1&amp;zoom=4&amp;edge=curl&amp;imgtk=AFLRE73Q2PUv9z_exyNX2m4t7xwCw6MZjQO4sWe0tgVeDQ5eT7DhUezzlFFxNlC7qZ2zoFGv1pbV63hGchFlJHiEAlsitqIi68bzfRAaVU9NE9YjM5eDqvQk-ZaJfG6XVuljxxCoCxfw&amp;source=gbs_api\",\n" +
//                    "      \"extraLarge\": \"http://books.google.com/books/publisher/content?id=Qk4rDwAAQBAJ&amp;printsec=frontcover&amp;img=1&amp;zoom=6&amp;edge=curl&amp;imgtk=AFLRE73XhMdgWQg2LPce-yQUK3ieEfvTwXzuiHcfT7VnK51-aDg8pl3rXBxvxJktEsq6nPjb2E1J3YTzJvzQ7ynfP7eFNrbQF1svWgyIAVNKoxsuh-2gOXxUIx15WHvtbmlcq7lJz-PO&amp;source=gbs_api\"\n" +
//                    "    },\n" +
//                    "    \"language\": \"en\",\n" +
//                    "    \"previewLink\": \"http://books.google.ca/books?id=Qk4rDwAAQBAJ&amp;hl=&amp;source=gbs_api\",\n" +
//                    "    \"infoLink\": \"https://play.google.com/store/books/details?id=Qk4rDwAAQBAJ&amp;source=gbs_api\",\n" +
//                    "    \"canonicalVolumeLink\": \"https://play.google.com/store/books/details?id=Qk4rDwAAQBAJ\"\n" +
//                    "  },\n" +
//                    "  \"layerInfo\": {\n" +
//                    "    \"layers\": [\n" +
//                    "      {\n" +
//                    "        \"layerId\": \"geo\",\n" +
//                    "        \"volumeAnnotationsVersion\": \"18\"\n" +
//                    "      }\n" +
//                    "    ]\n" +
//                    "  },\n" +
//                    "  \"saleInfo\": {\n" +
//                    "    \"country\": \"CA\",\n" +
//                    "    \"saleability\": \"FOR_SALE\",\n" +
//                    "    \"isEbook\": true,\n" +
//                    "    \"listPrice\": {\n" +
//                    "      \"amount\": 11.99,\n" +
//                    "      \"currencyCode\": \"CAD\"\n" +
//                    "    },\n" +
//                    "    \"retailPrice\": {\n" +
//                    "      \"amount\": 11.99,\n" +
//                    "      \"currencyCode\": \"CAD\"\n" +
//                    "    },\n" +
//                    "    \"buyLink\": \"https://play.google.com/store/books/details?id=Qk4rDwAAQBAJ&amp;rdid=book-Qk4rDwAAQBAJ&amp;rdot=1&amp;source=gbs_api\",\n" +
//                    "    \"offers\": [\n" +
//                    "      {\n" +
//                    "        \"finskyOfferType\": 1,\n" +
//                    "        \"listPrice\": {\n" +
//                    "          \"amountInMicros\": 11990000,\n" +
//                    "          \"currencyCode\": \"CAD\"\n" +
//                    "        },\n" +
//                    "        \"retailPrice\": {\n" +
//                    "          \"amountInMicros\": 11990000,\n" +
//                    "          \"currencyCode\": \"CAD\"\n" +
//                    "        },\n" +
//                    "        \"giftable\": true\n" +
//                    "      }\n" +
//                    "    ]\n" +
//                    "  },\n" +
//                    "  \"accessInfo\": {\n" +
//                    "    \"country\": \"CA\",\n" +
//                    "    \"viewability\": \"PARTIAL\",\n" +
//                    "    \"embeddable\": true,\n" +
//                    "    \"publicDomain\": false,\n" +
//                    "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
//                    "    \"epub\": {\n" +
//                    "      \"isAvailable\": true,\n" +
//                    "      \"acsTokenLink\": \"http://books.google.ca/books/download/How_to_Build_a_Car_The_Autobiography_of-sample-epub.acsm?id=Qk4rDwAAQBAJ&amp;format=epub&amp;output=acs4_fulfillment_token&amp;dl_type=sample&amp;source=gbs_api\"\n" +
//                    "    },\n" +
//                    "    \"pdf\": {\n" +
//                    "      \"isAvailable\": false\n" +
//                    "    },\n" +
//                    "    \"webReaderLink\": \"http://play.google.com/books/reader?id=Qk4rDwAAQBAJ&amp;hl=&amp;printsec=frontcover&amp;source=gbs_api\",\n" +
//                    "    \"accessViewStatus\": \"SAMPLE\",\n" +
//                    "    \"quoteSharingAllowed\": false\n" +
//                    "  }")
            val bookmark1 = Bookmarks("Qk4rDwAAQBAJ", "{ \"id\": \"wtf\"} ")

            db.libraryDao().insert(bookmark1)

            val bookmark2 = Bookmarks("Hht2CgAAQBAJ", "{ \"id\": \"222\"} ")
            db.libraryDao().insert(bookmark2)
            val bookmark3 = Bookmarks("WbZ4OQAACAAJ", "{ \"id\": \"hello3\"} ")
            db.libraryDao().insert(bookmark3)
            val bookmark4 = Bookmarks("brITEAAAQBAJ", "{ \"id\": \"wold4\"} ")


            db.libraryDao().insert(bookmark4)
        }
    }
}


class ResourcesHelper {
    companion object {
        val testJson = Resources.getSystem().getString(R.string.book_json_string)
    }
}