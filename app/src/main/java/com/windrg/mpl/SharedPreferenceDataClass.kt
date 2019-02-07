import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceDataClass private constructor(protected var mContext: Context) {
    private val mSharedPreferences: SharedPreferences
    private val mSharedPreferencesEditor: SharedPreferences.Editor?

    init {
        mSharedPreferences = mContext.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        mSharedPreferencesEditor = mSharedPreferences.edit()
    }

    /**
     * Stores String value in preference
     *
     * @param key   key of preference
     * @param value value for that key
     */
    fun setValue(key: String, value: String) {
        mSharedPreferencesEditor!!.putString(key, value)
        mSharedPreferencesEditor.commit()
    }

    /**
     * Stores int value in preference
     *
     * @param key   key of preference
     * @param value value for that key
     */
    fun setValue(key: String, value: Int) {
        mSharedPreferencesEditor!!.putInt(key, value)
        mSharedPreferencesEditor.commit()
    }

    /**
     * Stores Double value in String format in preference
     *
     * @param key   key of preference
     * @param value value for that key
     */
    fun setValue(key: String, value: Double) {
        setValue(key, java.lang.Double.toString(value))
    }

    /**
     * Stores long value in preference
     *
     * @param key   key of preference
     * @param value value for that key
     */
    fun setValue(key: String, value: Long) {
        mSharedPreferencesEditor!!.putLong(key, value)
        mSharedPreferencesEditor.commit()
    }

    /**
     * Stores boolean value in preference
     *
     * @param key   key of preference
     * @param value value for that key
     */
    fun setValue(key: String, value: Boolean) {
        mSharedPreferencesEditor!!.putBoolean(key, value)
        mSharedPreferencesEditor.commit()
    }

    /**
     * Retrieves String value from preference
     *
     * @param key          key of preference
     * @param defaultValue default value if no key found
     */
    fun getStringValue(key: String, defaultValue: String): String? {
        return mSharedPreferences.getString(key, defaultValue)
    }

    /**
     * Retrieves int value from preference
     *
     * @param key          key of preference
     * @param defaultValue default value if no key found
     */
    fun getIntValue(key: String, defaultValue: Int): Int {
        return mSharedPreferences.getInt(key, defaultValue)
    }

    /**
     * Retrieves long value from preference
     *
     * @param key          key of preference
     * @param defaultValue default value if no key found
     */
    fun getLongValue(key: String, defaultValue: Long): Long {
        return mSharedPreferences.getLong(key, defaultValue)
    }

    /**
     * Retrieves boolean value from preference
     *
     * @param keyFlag      key of preference
     * @param defaultValue default value if no key found
     */
    fun getBoolanValue(keyFlag: String, defaultValue: Boolean): Boolean {
        return mSharedPreferences.getBoolean(keyFlag, defaultValue)
    }

    /**
     * Removes key from preference
     *
     * @param key key of preference that is to be deleted
     */
    fun removeKey(key: String) {
        if (mSharedPreferencesEditor != null) {
            mSharedPreferencesEditor.remove(key)
            mSharedPreferencesEditor.commit()
        }
    }


    /**
     * Clears all the preferences stored
     */
    fun clear() {
        mSharedPreferencesEditor!!.clear().commit()
    }

    companion object {
        private var mSharedPreferenceDataClass: SharedPreferenceDataClass? = null

        /**
         * Creates single instance of SharedPreferenceDataClass
         *
         * @param context context of Activity or Service
         * @return Returns instance of SharedPreferenceDataClass
         */
        @Synchronized
        fun getInstance(context: Context): SharedPreferenceDataClass {

            if (mSharedPreferenceDataClass == null) {
                mSharedPreferenceDataClass = SharedPreferenceDataClass(context.applicationContext)
            }
            return mSharedPreferenceDataClass as SharedPreferenceDataClass
        }
    }
}