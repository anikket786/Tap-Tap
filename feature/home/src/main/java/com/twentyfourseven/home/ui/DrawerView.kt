package com.twentyfourseven.home.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.twentyfourseven.designsystem.theme.WhiteTheme
import com.twentyfourseven.home.R
import com.twentyfourseven.util.*

@Composable
fun DrawerView() {
    val context = LocalContext.current

    LazyColumn {
        item {
            DrawerItem(
                imageVector = Icons.Filled.Info,
                title = stringResource(id = R.string.terms_and_conditions)
            ) {
                openChromeCustomTab(context, kTermsConditionsUrl)
                AnalyticsManager.logEvent(AnalyticsEvent.DRAWER_T_AND_C_CLICKED)
            }
        }
        item {
            Divider(modifier = Modifier.padding(horizontal = 16.dp))
        }
        item {
            DrawerItem(
                imageVector = Icons.Filled.List,
                title = stringResource(id = R.string.privacy_policy)
            ) {
                openChromeCustomTab(context, kPrivacyPolicyUrl)
                AnalyticsManager.logEvent(AnalyticsEvent.DRAWER_PRIVACY_POLICY_CLICKED)
            }
        }
        item {
            Divider(modifier = Modifier.padding(horizontal = 16.dp))
        }
        item {
            DrawerItem(
                imageVector = Icons.Filled.Star,
                title = stringResource(id = R.string.rate_us)
            ) {
                openUrl(context, kPlayStoreUrl)
                AnalyticsManager.logEvent(AnalyticsEvent.DRAWER_RATE_US_CLICKED)
            }
        }
        item {
            Divider(modifier = Modifier.padding(horizontal = 16.dp))
        }
        item {
            DrawerItem(
                imageVector = Icons.Filled.Share,
                title = stringResource(id = R.string.share)
            ) {
                val text = context.getString(R.string.share_app_text, kPlayStoreUrl)
                shareText(context, text)
                AnalyticsManager.logEvent(AnalyticsEvent.DRAWER_SHARE_CLICKED)
            }
        }
        item {
            Divider(modifier = Modifier.padding(horizontal = 16.dp))
        }
    }
}

@Composable
private fun DrawerItem(
    imageVector: ImageVector,
    title: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(64.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = title
        )
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = title
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDrawer() {
    WhiteTheme {
        DrawerView()
    }
}