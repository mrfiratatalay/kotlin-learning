package com.firatatalay.composablearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.firatatalay.composablearticle.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableArticleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InstagramApp()
                }
            }
        }
    }
}

// Navigation Routes
sealed class Screen(val route: String, val title: String) {
    object Login : Screen("login", "Login")
    object Home : Screen("home", "Home")
    object Search : Screen("search", "Search")
    object Camera : Screen("camera", "Camera")
    object Activity : Screen("activity", "Activity")
    object Profile : Screen("profile", "Profile")
    object PostDetail : Screen("post_detail", "Post")
    object UserProfile : Screen("user_profile", "Profile")
}

@Composable
fun InstagramApp() {
    val navController = rememberNavController()
    var isLoggedIn by remember { mutableStateOf(false) }

    if (isLoggedIn) {
        InstagramMainContent(navController)
    } else {
        LoginScreen(onLoginSuccess = { isLoggedIn = true })
    }
}

@Composable
fun InstagramMainContent(navController: NavHostController) {
    var selectedTab by remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxSize()) {
        // Main content
        Box(modifier = Modifier.weight(1f)) {
            when (selectedTab) {
                0 -> HomeScreen(navController)
                1 -> SearchScreen(navController)
                2 -> CameraScreen(navController)
                3 -> ActivityScreen(navController)
                4 -> ProfileScreen(navController)
            }
        }

        // Bottom Navigation
        InstagramBottomNavigation(
            selectedTab = selectedTab,
            onTabSelected = { selectedTab = it }
        )
    }
}

@Composable
fun InstagramBottomNavigation(
    selectedTab: Int,
    onTabSelected: (Int) -> Unit
) {
    NavigationBar(
        containerColor = SurfaceLight,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        val tabs = listOf(
            Triple(Icons.Outlined.Home, Icons.Filled.Home, "Home"),
            Triple(Icons.Outlined.Search, Icons.Filled.Search, "Search"),
            Triple(Icons.Outlined.Add, Icons.Filled.Add, "Create"),
            Triple(Icons.Outlined.FavoriteBorder, Icons.Filled.Favorite, "Activity"),
            Triple(Icons.Outlined.Person, Icons.Filled.Person, "Profile")
        )

        tabs.forEachIndexed { index, (outlinedIcon, filledIcon, label) ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = if (selectedTab == index) filledIcon else outlinedIcon,
                        contentDescription = label,
                        modifier = Modifier.size(28.dp)
                    )
                },
                selected = selectedTab == index,
                onClick = { onTabSelected(index) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = TextPrimary,
                    unselectedIconColor = TextSecondary,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}

// Login Screen
@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF833AB4),
                        Color(0xFFC13584),
                        Color(0xFFE1306C),
                        Color(0xFFFD1D1D),
                        Color(0xFFF56040),
                        Color(0xFFF77737),
                        Color(0xFFFCAF45),
                        Color(0xFFFFDC80)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Instagram Logo
            Text(
                text = "Instagram",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 48.sp
            )

            Spacer(modifier = Modifier.height(60.dp))

            // Login Form
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.95f)
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    var username by remember { mutableStateOf("") }
                    var password by remember { mutableStateOf("") }

                    OutlinedTextField(
                        value = username,
                        onValueChange = { username = it },
                        label = { Text("Username or Email") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp)
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = onLoginSuccess,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = PrimaryBlue
                        )
                    ) {
                        Text(
                            "Log In",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    TextButton(onClick = { /* Forgot password */ }) {
                        Text(
                            "Forgot password?",
                            color = PrimaryBlue
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Sign up link
            Row {
                Text("Don't have an account? ", color = Color.White)
                Text(
                    "Sign up",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { /* Sign up */ }
                )
            }
        }
    }
}

// Home Screen - Instagram Feed
@Composable
fun HomeScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        // Top App Bar
        InstagramTopBar()

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            // Stories Row
            item {
                StoriesRow()
            }

            // Posts
            items(samplePosts) { post ->
                InstagramPost(post = post)
            }
        }
    }
}

@Composable
fun InstagramTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Instagram",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = TextPrimary
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = "Notifications",
                modifier = Modifier.size(28.dp),
                tint = TextPrimary
            )
            Icon(
                imageVector = Icons.Outlined.Send,
                contentDescription = "Messages",
                modifier = Modifier.size(28.dp),
                tint = TextPrimary
            )
        }
    }
}

@Composable
fun StoriesRow() {
    LazyRow(
        modifier = Modifier.padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        // Your story
        item {
            StoryItem(
                imageUrl = "",
                username = "Your Story",
                isYourStory = true
            )
        }

        // Other stories
        items(sampleStories) { story ->
            StoryItem(
                imageUrl = story.imageUrl,
                username = story.username,
                isYourStory = false
            )
        }
    }
}

@Composable
fun StoryItem(
    imageUrl: String,
    username: String,
    isYourStory: Boolean
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(80.dp)
    ) {
        Box(
            modifier = Modifier.size(70.dp)
        ) {
            // Story ring
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.linearGradient(
                            colors = if (isYourStory) {
                                listOf(Color.Gray, Color.Gray)
                            } else {
                                listOf(
                                    Color(0xFFF77737),
                                    Color(0xFFFCAF45),
                                    Color(0xFFE1306C),
                                    Color(0xFF833AB4)
                                )
                            }
                        ),
                        shape = CircleShape
                    )
                    .padding(2.dp)
            ) {
                // Profile image
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White, CircleShape)
                        .padding(2.dp)
                        .background(Color.LightGray, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    if (isYourStory) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add Story",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    } else {
                        // Placeholder for profile image
                        Text(
                            text = username.first().toString(),
                            color = Color.White,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = username,
            fontSize = 12.sp,
            color = TextPrimary,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun InstagramPost(post: Post) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        // Post Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Profile picture
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .background(Color.LightGray, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = post.username.first().toString(),
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = post.username,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = TextPrimary
                )
                if (post.location.isNotEmpty()) {
                    Text(
                        text = post.location,
                        fontSize = 12.sp,
                        color = TextSecondary
                    )
                }
            }

            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More options",
                tint = TextPrimary
            )
        }

        // Post Image
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            // Placeholder for post image
                            Text(
                    text = "📸",
                    fontSize = 64.sp
                )
        }

        // Post Actions
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                var isLiked by remember { mutableStateOf(post.isLiked) }

                Icon(
                    imageVector = if (isLiked) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = "Like",
                    tint = if (isLiked) Color.Red else TextPrimary,
                    modifier = Modifier
                        .size(28.dp)
                        .clickable { isLiked = !isLiked }
                )

                Box(
                    modifier = Modifier.size(28.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "💬",
                        fontSize = 24.sp
                    )
                }

                Icon(
                    imageVector = Icons.Outlined.Send,
                    contentDescription = "Share",
                    tint = TextPrimary,
                    modifier = Modifier.size(28.dp)
                )
            }

            var isBookmarked by remember { mutableStateOf(false) }

            Box(
                modifier = Modifier
                    .size(28.dp)
                    .clickable { isBookmarked = !isBookmarked },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = if (isBookmarked) "🔖" else "🏷️",
                    fontSize = 24.sp
                )
            }
        }

        // Likes count
        Text(
            text = "${post.likesCount} likes",
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            color = TextPrimary,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        // Caption
        if (post.caption.isNotEmpty()) {
            Text(
                text = buildString {
                    append(post.username)
                    append(" ")
                    append(post.caption)
                },
                fontSize = 14.sp,
                color = TextPrimary,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
            )
        }

        // Comments preview
        if (post.commentsCount > 0) {
            Text(
                text = "View all ${post.commentsCount} comments",
                fontSize = 14.sp,
                color = TextSecondary,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp)
            )
        }

        // Time
        Text(
            text = post.timeAgo,
            fontSize = 12.sp,
            color = TextSecondary,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp)
        )
    }
}

// Search Screen
@Composable
fun SearchScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        // Search Bar
        OutlinedTextField(
            value = "",
            onValueChange = { },
            placeholder = { Text("Search") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(8.dp)
        )

        // Explore Grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(sampleExplorePosts) { post ->
                Box(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .background(Color.LightGray),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "📷",
                        fontSize = 32.sp
                    )
                }
            }
        }
    }
}

// Camera Screen
@Composable
fun CameraScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "📷",
                fontSize = 64.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Camera Feature",
                color = Color.White,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Tap to take a photo",
                color = Color.Gray,
                fontSize = 14.sp
            )
        }
    }
}

// Activity Screen
@Composable
fun ActivityScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text(
                text = "Activity",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        items(sampleActivities) { activity ->
            ActivityItem(activity = activity)
        }
    }
}

@Composable
fun ActivityItem(activity: Activity) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Profile picture
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.LightGray, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = activity.username.first().toString(),
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = buildString {
                    append(activity.username)
                    append(" ")
                    append(activity.action)
                },
                fontSize = 14.sp,
                color = TextPrimary
            )

            Text(
                text = activity.timeAgo,
                fontSize = 12.sp,
                color = TextSecondary
            )
        }

        if (activity.hasPostThumbnail) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "📷",
                    fontSize = 16.sp
                )
            }
        }
    }
}

// Profile Screen
@Composable
fun ProfileScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            ProfileHeader()
        }

        item {
            ProfileStats()
        }

        item {
            ProfileBio()
        }

        item {
            ProfileActionButtons()
        }

        item {
            Divider(modifier = Modifier.padding(vertical = 16.dp))
        }

        item {
            PostsGrid()
        }
    }
}

@Composable
fun ProfileHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Profile picture
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.LightGray, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "U",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.width(24.dp))

        // Stats
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ProfileStat("124", "Posts")
            ProfileStat("1.2M", "Followers")
            ProfileStat("256", "Following")
        }
    }
}

@Composable
fun ProfileStat(number: String, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = number,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = TextPrimary
        )
        Text(
            text = label,
            fontSize = 14.sp,
            color = TextPrimary
        )
    }
}

@Composable
fun ProfileBio() {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Your Name",
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            color = TextPrimary
        )

        Text(
            text = "Your bio goes here ✨\n📧 contact@example.com\n🌍 Around the world",
            fontSize = 14.sp,
            color = TextPrimary,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun ProfileActionButtons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(
            onClick = { },
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray
            )
        ) {
            Text("Edit Profile", color = TextPrimary)
        }

        Button(
            onClick = { },
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray
            )
        ) {
            Text("Share Profile", color = TextPrimary)
        }
    }
}

@Composable
fun ProfileStats() {
    // This is already included in ProfileHeader
}

@Composable
fun PostsGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp),
        modifier = Modifier.height(600.dp) // Fixed height for demo
    ) {
        items(sampleUserPosts) { post ->
            Box(
                modifier = Modifier
                    .aspectRatio(1f)
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "📷",
                    fontSize = 32.sp
                )
            }
        }
    }
}

// Data Models
data class Post(
    val id: String,
    val username: String,
    val userImage: String,
    val postImage: String,
    val caption: String,
    val likesCount: Int,
    val commentsCount: Int,
    val timeAgo: String,
    val location: String = "",
    val isLiked: Boolean = false
)

data class Story(
    val id: String,
    val username: String,
    val imageUrl: String,
    val isViewed: Boolean = false
)

data class Activity(
    val id: String,
    val username: String,
    val action: String,
    val timeAgo: String,
    val hasPostThumbnail: Boolean = false
)

// Sample Data
val samplePosts = listOf(
    Post("1", "john_doe", "", "", "Beautiful sunset! 🌅", 245, 12, "2h", "Istanbul, Turkey"),
    Post("2", "jane_smith", "", "", "Coffee time ☕", 189, 8, "4h", "New York"),
    Post("3", "travel_lover", "", "", "Amazing view from the mountains! 🏔️", 567, 34, "6h", "Swiss Alps"),
    Post("4", "foodie_life", "", "", "Delicious pasta 🍝", 423, 21, "8h", "Rome, Italy"),
    Post("5", "nature_photo", "", "", "Forest therapy 🌲", 678, 45, "12h", "Amazon Forest")
)

val sampleStories = listOf(
    Story("1", "john_doe", ""),
    Story("2", "jane_smith", ""),
    Story("3", "travel_lover", ""),
    Story("4", "foodie_life", ""),
    Story("5", "nature_photo", "")
)

val sampleActivities = listOf(
    Activity("1", "john_doe", "liked your photo.", "2m", true),
    Activity("2", "jane_smith", "started following you.", "5m"),
    Activity("3", "travel_lover", "commented: Amazing shot!", "10m", true),
    Activity("4", "foodie_life", "liked your photo.", "15m", true),
    Activity("5", "nature_photo", "liked your photo.", "1h", true)
)

val sampleExplorePosts = (1..30).map { "post_$it" }
val sampleUserPosts = (1..24).map { "user_post_$it" }

@Preview(showBackground = true)
@Composable
fun InstagramAppPreview() {
    ComposableArticleTheme {
        InstagramApp()
    }
}
