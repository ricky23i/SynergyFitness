import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { PostComponent } from './post/post.component';
import { CalorieComponent } from './calorie/calorie.component';
import { HeaderComponent } from './header/header.component';
import { BuildGuideComponent } from './build-guide/build-guide.component';
import { SignupComponent } from './signup/signup.component';
import { UploadComponent } from './upload/upload.component';
import { UserService } from './services/user.service';
import { UrlService } from './services/url.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    ProfileComponent,
    PostComponent,
    CalorieComponent,
    HeaderComponent,
    BuildGuideComponent,
    SignupComponent,
    UploadComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    UserService,
    UrlService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
