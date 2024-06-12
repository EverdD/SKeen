import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun saveAuthToken(token: String?) {
        val editor = sharedPreferences.edit()
        editor.putString(KEY_AUTH_TOKEN, token)
        editor.apply()
    }

    fun fetchAuthToken(): String? {
        return sharedPreferences.getString(KEY_AUTH_TOKEN, null)
    }

    fun clearAuthToken() {
        val editor = sharedPreferences.edit()
        editor.remove(KEY_AUTH_TOKEN)
        editor.apply()
    }

    // Add these methods for email
    fun saveUserEmail(email: String?) {
        val editor = sharedPreferences.edit()
        editor.putString(KEY_USER_EMAIL, email)
        editor.apply()
    }

    fun fetchUserEmail(): String? {
        return sharedPreferences.getString(KEY_USER_EMAIL, null)
    }

    fun clearUserEmail() {
        val editor = sharedPreferences.edit()
        editor.remove(KEY_USER_EMAIL)
        editor.apply()
    }

    companion object {
        private const val PREF_NAME = "SessionManagerPref"
        private const val KEY_AUTH_TOKEN = "auth_token"
        private const val KEY_USER_EMAIL = "user_email"
    }
}
