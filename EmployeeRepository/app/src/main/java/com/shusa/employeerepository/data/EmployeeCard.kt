package com.shusa.employeerepository.data

import android.util.Log
import android.widget.ImageView
import com.shusa.employeerepository.R

// Explicit Constructor
class EmployeeCard(
    _uuid: String?,
    _fullName: String?,
    _phoneNumber: String?,
    _emailAddress: String?,
    _biography: String?,
    _photoSmall: ImageView?,
    _photoLarge: ImageView?,
    _team: String?,
    _employeeType: String?
) {
    // Explicit Data Members
    private var uuid: String? = _uuid
    private var fullName: String? = _fullName
    private var phoneNumber: String? = _phoneNumber
    private var emailAddress: String? = _emailAddress
    private var biography: String? = _biography
    private var photoSmall: ImageView? = _photoSmall
    private var photoLarge: ImageView? = _photoLarge
    private var team: String? = _team
    private var employeeType: String? = _employeeType

    // Initialization of Employee Object
    init {
        Log.d(GlobalContext.getCurrentContext().getString(R.string.log_initialized), javaClass.name)
    }

    // Getters
    fun getUUID(): String = uuid as String
    fun getFullName(): String = fullName as String
    fun getPhoneNumber(): String = phoneNumber as String
    fun getEmailAddress(): String = emailAddress as String
    fun getBiography(): String = biography as String
    fun getPhotoSmall(): ImageView = photoSmall as ImageView
    fun getPhotoLarge(): ImageView = photoLarge as ImageView
    fun getTeam(): String = team as String
    fun getEmployeeType(): String = employeeType as String
}