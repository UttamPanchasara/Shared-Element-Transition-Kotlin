# Shared Element Transition Demo Kotlin
Android Shared element transition example in **Kotlin** from Fragment viewpager to Activity
**Fragment(Recyclerview) to Activity**

| Animation with Large image item | Animation with Small image item | Animation with Grid image List |
| ------------------------------- | ------------------------------- |--------------------------------|
| <img src="http://i.imgur.com/0FF8tvk.gif" height="400" alt="Screenshot"/>  | <img src="https://i.imgur.com/lNXYTyy.gif" height="400" alt="Screenshot"/> | <img src="https://i.imgur.com/pNC1BqE.gif" height="400" alt="Screenshot"/>  |


# To enable Shared element transition 
Note that the shared element transitions require Android 5.0 (API level 21) and above and will be ignored for any lower API versions. 

### 1. Enable Window Content Transitions

 ```xml
 <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
   <!-- other theme lines. -->

   // enable window content transition
   <item name="android:windowContentTransitions">true</item>
 </style>
 ```
 
 ### 2. Assign a Common Transition Name
 Assign a common transition name to the shared elements in both layouts. Use the `android:transitionName` attribute.
 
 For e.g. in `FirstActivity.xml` OR `list_layout.xml` 
 
 ```xml
 <ImageView
          android:id="@+id/ivProfile"
          android:transitionName="profile"
          android:scaleType="centerCrop"
          android:layout_width="match_parent"
          android:layout_height="160dp" />
 ```
 
 In `DetailActivity.xml`
 
 ```xml
 <ImageView
          android:id="@+id/ivDetailProfile"
          android:transitionName="profile"
          android:scaleType="centerCrop"
          android:layout_width="match_parent"
          android:layout_height="250dp" />
 ```
 
 ### 3. Start Activity
 
 Start the target activity by specifying a bundle of those shared elements and views from the source.
 
 ***Single Shared Element***
 ```kotlin
 val detailIntent = Intent(mActivity, DetailActivity::class.java)
 val imageViewPair = Pair.create<View, String>(imageView, getString("YourTransitionName"))
 val options = ActivityOptionsCompat.makeSceneTransitionAnimation(mActivity, imageViewPair)
 
 detailIntent.putExtra(LargeImageDetailActivity.DATA, data) // pass your bundle data
 startActivity(detailIntent, options.toBundle())
 ```
 
 ***Multiple Shared Element***
 ```kotlin
 val detailIntent = Intent(mActivity, LargeImageDetailActivity::class.java)
 val imageViewPair = Pair.create<View, String>(imageView, "YourTransitionName")
 val textViewPair = Pair.create<View, String>(textView, "YourTransitionName")
 val options = ActivityOptionsCompat.makeSceneTransitionAnimation(mActivity, imageViewPair, textViewPair)
 
 detailIntent.putExtra(LargeImageDetailActivity.DATA, data) // pass your bundle data
 startActivity(detailIntent, options.toBundle())
 ```
 
 Done! Just make sure that you don't have multiple views with same transition name in source or destination layout view.
 
 ### To reverse the scene Transition animation
 To reverse the scene transition animation when you finish the second activity, 
 call the `Activity.supportFinishAfterTransition()`
 
 Example :
 
 ```kotlin
 override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            //to reverse the scene transition animation
            supportFinishAfterTransition()
        }
        return super.onOptionsItemSelected(item)
 }
 ```
 
 ## References 
 
 - https://github.com/googlesamples/android-ActivitySceneTransitionBasic
 - https://github.com/codepath/android_guides/wiki/Shared-Element-Activity-Transition
 
 ## Questions?
 
 **Ping-Me on :** 
 
 ![alt text][1.1] : https://twitter.com/utm_panchasara
 
 ![alt text][2.2] : https://www.facebook.com/UttamPanchasara94
 
 [1.1]: http://i.imgur.com/wWzX9uB.png (twitter icon with padding)
 [2.2]: http://i.imgur.com/fep1WsG.png (facebook icon without padding)
 
 <a href="https://stackoverflow.com/users/5719935/uttam-panchasara">
<img src="https://stackoverflow.com/users/flair/5719935.png" width="208" height="58" alt="profile for Uttam Panchasara at Stack Overflow, Q&amp;A for professional and enthusiast programmers" title="profile for Uttam Panchasara at Stack Overflow, Q&amp;A for professional and enthusiast programmers">
</a>
 
 # Donate
> If you found this project helpful or you learned something from the source code and want to thank me, consider buying me a cup of :coffee:
- Paypal **https://paypal.me/UttamPanchasara**
 
