package br.edu.unisep.exemplofb.domain.repository

import br.edu.unisep.exemplofb.domain.dto.LoginDto
import br.edu.unisep.exemplofb.domain.dto.RegisterDto
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginRepository(private val service: FirebaseAuth) {

    suspend fun register(registerDto: RegisterDto): Task<AuthResult> {

        return this.service.createUserWithEmailAndPassword(
            registerDto.username,
            registerDto.password
        );
    }

    suspend fun login(loginDto: LoginDto): Task<AuthResult> {

        return this.service.signInWithEmailAndPassword(loginDto.username, loginDto.password);
    }



}