package com.example.mamfoods

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mamfoods.screens.AddItemScreen
import com.example.mamfoods.screens.AllItemsScreen
import com.example.mamfoods.screens.DashboardScreen
import com.example.mamfoods.viewmodel.AuthViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") {
            SplashScreen(
                onNavigateToOnboarding = {
                    navController.navigate("onboarding")
                }
            )
        }
        composable("onboarding") {
            OnboardingScreen(
                onNextClick = {
                    navController.navigate("login")
                })
        }
        composable("login") {
            LoginScreen(
                viewModel = AuthViewModel(),
                onLoginSuccess = {
                    navController.navigate("dashboard")  // Ganti 'home' ke 'dashboard'
                },
                onSignUpClick = {
                    navController.navigate("signup")
                }
            )
        }
        composable("signup") {
            SignUpScreen(
                onSignUpClick = { /* Implement sign up */ },
                onFacebookSignUpClick = { /* Implement Facebook login */ },
                onGoogleSignUpClick = { /* Implement Google login */ },
                onLoginClick = { navController.navigate("login") },
                viewModel = AuthViewModel(),
                onSignUpSuccess = { navController.navigate("dashboard") }
            )
        }
        composable("dashboard") {
            DashboardScreen(
                onAddItemClick = { navController.navigate("add_item") },
                onViewAllItemsClick = { navController.navigate("all_items") },
                onDeliveryStatusClick = { navController.navigate("out_for_delivery") },
                onProfileClick = { navController.navigate("admin_profile") },
                onCreateUserClick = { navController.navigate("create_user") }
            )
        }

        composable("add_item") {
            AddItemScreen(onBackClick = { navController.popBackStack() }, onAddItemClick = { navController.popBackStack() })
        }

        composable("all_items") {
            AllItemsScreen(onBackClick = { navController.popBackStack() })
        }

        composable("home") {
            HomeScreen(
                navController = navController
            )
        }
    }
}

fun DashboardScreen(onAddItemClick: () -> Unit, onViewAllItemsClick: () -> Unit, onDeliveryStatusClick: () -> Unit, onProfileClick: () -> Unit, onCreateUserClick: () -> Unit) {

}
