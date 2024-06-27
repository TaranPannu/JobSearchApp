package com.example.jobsearch.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.jobsearch.Retrofit.ApiDataClass.Job

@Database(entities = [Job::class],
    version = 1,
    exportSchema = false)
@TypeConverters(Converters::class)
abstract class JobDataBase:RoomDatabase() {

    abstract fun getJobDao(): Dao
    companion object {
        /** companion object: This block is used to define static fields and methods.
        In this case, it contains the database name and a singleton instance of the NoteDatabase.*/

        private const val DB_NAME = "note_database.db"
        private var instance: JobDataBase?= null

        /**operator fun invoke: This allows the class to be called like a function, which simplifies the instance retrieval.
        synchronized(Any()): This ensures that the database instance creation is thread-safe.
        instance ?: buildDatabase(context).also { instance = it }: This checks if the instance is null.
        If it is, it calls buildDatabase to create a new instance and assigns it to instance.*/
        operator fun invoke(context: Context)= instance ?: synchronized(Any()) {
            instance ?: buildDatabase(context).also {
                instance =it
            } }

        /**This private function creates the actual database using Room's databaseBuilder.*/
        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            JobDataBase::class.java,
            DB_NAME
        ).build() }
}