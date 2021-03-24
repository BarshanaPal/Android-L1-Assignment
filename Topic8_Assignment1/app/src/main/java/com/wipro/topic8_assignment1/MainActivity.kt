package com.wipro.topic8_assignment1

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContentUris
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private var uriContact: Uri? = null
    private var contactID: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickSelectContact(btnSelectContact: View?) {

        // using native contacts selection
        // Intent.ACTION_PICK = Pick an item from the data, returning what was selected.
        startActivityForResult(Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI), REQUEST_CODE_PICK_CONTACTS)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_PICK_CONTACTS && resultCode == Activity.RESULT_OK) {
            Log.d(TAG, "Response: " + data.toString())
            uriContact = data!!.data
            retrieveContactName()
            retrieveContactNumber()
            try {
                retrieveContactPhoto()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }



    private fun retrieveContactPhoto() {
        var photo: Bitmap? = null
        val inputStream = ContactsContract.Contacts.openContactPhotoInputStream(contentResolver,
                ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI,contactID as Long))
        if (inputStream != null) {
            photo = BitmapFactory.decodeStream(inputStream)
            val imageView = findViewById<View>(R.id.img_contact) as ImageView
            imageView.setImageBitmap(photo)
        }
        inputStream!!.close()
    }

    private fun retrieveContactNumber() {
        var contactNumber: String? = null

        // getting contacts ID
        val cursorID = contentResolver.query(uriContact!!, arrayOf(ContactsContract.Contacts._ID),
                null, null, null)
        if (cursorID!!.moveToFirst()) {
            contactID = cursorID.getString(cursorID.getColumnIndex(ContactsContract.Contacts._ID))
        }
        cursorID.close()
        Log.d(TAG, "Contact ID: $contactID")

        // Using the contact ID now we will get contact phone number
        val cursorPhone = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, arrayOf(ContactsContract.CommonDataKinds.Phone.NUMBER),
                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ? AND " +
                        ContactsContract.CommonDataKinds.Phone.TYPE + " = " +
                        ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE, arrayOf(contactID),
                null)
        if (cursorPhone!!.moveToFirst()) {
            contactNumber = cursorPhone.getString(cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
        }
        cursorPhone.close()
        Log.d(TAG, "Contact Phone Number: $contactNumber")
    }

    private fun retrieveContactName() {
        var contactName: String? = null

        // querying contact data store
        val cursor = contentResolver.query(uriContact!!, null, null, null, null)
        if (cursor!!.moveToFirst()) {

            // DISPLAY_NAME = The display name for the contact.
            // HAS_PHONE_NUMBER =   An indicator of whether this contact has at least one phone number.
            contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
        }
        cursor.close()
        Log.d(TAG, "Contact Name: $contactName")
    }

    companion object {
        private val TAG = MainActivity::class.simpleName
        private const val REQUEST_CODE_PICK_CONTACTS = 1
    }
}