@Composable
fun AuthScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLogin by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    fun handleAuth() {
        val action = if (isLogin) FirebaseAuthManager::signIn else FirebaseAuthManager::signUp
        action(email, password) { success, error ->
            if (success) {
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Auth.route) { inclusive = true }
                }
            } else {
                errorMessage = error
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(if (isLogin) "Login" else "Register", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))

        OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(Modifier.height(16.dp))
        Button(onClick = { handleAuth() }, modifier = Modifier.fillMaxWidth()) {
            Text(if (isLogin) "Login" else "Sign Up")
        }

        Spacer(Modifier.height(8.dp))
        TextButton(onClick = { isLogin = !isLogin }) {
            Text(if (isLogin) "Don't have an account? Sign up" else "Already have an account? Login")
        }

        errorMessage?.let {
            Spacer(Modifier.height(12.dp))
            Text("⚠ $it", color = MaterialTheme.colorScheme.error)
        }
    }
}
