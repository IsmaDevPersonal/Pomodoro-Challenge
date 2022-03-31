package com.ismadev.pomodoro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class EditPomodoroTask : Fragment() {

    private var taskName: String? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        saveInstanceState: Bundle?
    ): View?
    {
        val view: View = inflater.inflate(R.layout.edit_pomodoro_task_activity, container, false)
        view.findViewById<Button>(R.id.btn_IniciarPomodoro).setOnClickListener {
            val editText: EditText = view.findViewById(R.id.et_NombreTarea)
            if (!editText.text.isEmpty()){
                taskName = editText.text.toString()

            }else{
                Toast.makeText(context, "Ingrese un nombre para la tarea", Toast.LENGTH_SHORT).show()
            }

        }
        return view }


}