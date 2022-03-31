package com.ismadev.pomodoro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.google.firebase.auth.FirebaseAuth

class AuthActivity : Fragment() {

    private var taskName: String? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        saveInstanceState: Bundle?
    ): View?
    {
        val view: View = inflater.inflate(R.layout.auth_activity, container, false)


        view.findViewById<Button>(R.id.login).setOnClickListener {
            val email : String = view.findViewById<EditText>(R.id.username).text.toString()
            val password : String = view.findViewById<EditText>(R.id.password).text.toString()
            signIn(email, password)
        }

        view.findViewById<Button>(R.id.register).setOnClickListener {
            val email : String = view.findViewById<EditText>(R.id.username).text.toString()
            val password : String = view.findViewById<EditText>(R.id.password).text.toString()
            signUp(email, password)
        }



        return view }


    private fun signIn(email : String, password : String){
        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(context, "Please enter email/pw", Toast.LENGTH_SHORT).show()
            return
        }else{
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener {
                if(it.isSuccessful){
                    Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                    val navController= NavHostFragment.findNavController(this)
                    if (navController.currentDestination?.id == R.id.authActivity)
                        navController.navigate(R.id.action_authActivity_to_editPomodoroTask)
                }else{
                    Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    private fun signUp(email : String, password : String){
        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(context, "Please enter email/pw", Toast.LENGTH_SHORT).show()
            return
        }else{
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                if(it.isSuccessful){
                    Toast.makeText(context, "Sign Up Successful", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(context, "Sign Up Failed", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}