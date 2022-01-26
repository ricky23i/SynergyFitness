import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { ProfileComponent } from './components/profile/profile.component';
import { PostComponent } from './components/post/post.component';
import { CalorieComponent } from './components/calorie/calorie.component';
import { HeaderComponent } from './components/header/header.component';
import { BuildGuideComponent } from './components/build-guide/build-guide.component';
import { SignupComponent } from './components/signup/signup.component';
import { UploadComponent } from './components/upload/upload.component';
import { UserService } from './services/user.service';
import { UrlService } from './services/url.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MaterialModule} from './material/material.module';
import { CreatePostComponent } from './tools/create-post/create-post.component';
import { UserprofileComponent } from './components/userprofile/userprofile.component';
import { ProfilesComponent } from './components/profiles/profiles.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    ProfileComponent,
    ProfilesComponent,
    PostComponent,
    CalorieComponent,
    HeaderComponent,
    BuildGuideComponent,
    SignupComponent,
    UploadComponent,
    CreatePostComponent,
    UserprofileComponent,
    ProfilesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MaterialModule
  ],
  providers: [
    UserService,
    UrlService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
