# FontStyler

A library to customize fonts from XML layout,

To get a Git project into your build:

Step 1. Add the JitPack repository to your build file
 
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.sunnag7:fontstyler:-SNAPSHOT'
	}
 
- Replace "TextView" with following "com.ninestack.fontstyler.FontStylerView"
- Add your font files to assets folder eg Lato-Bold.ttf
- add your font name as app:fontName="Lato-Bold" 
- set textStyle according to your font 

   <com.ninestack.fontstyler.FontStylerView
                    android:textStyle="bold"
                    android:text="@string/about_us"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:paddingTop="8dp"
                    app:fontName="Lato-Bold"
                    android:textSize="18sp"
                    android:id="@+id/textView64" />
                    
Share this release:

Link
That's it! The first time you request a project JitPack checks out the code, builds it and serves the build artifacts.

If the project doesn't have any GitHub Releases you can use the short commit hash or 'anyBranch-SNAPSHOT' as the version.
