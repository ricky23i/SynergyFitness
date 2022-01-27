import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BuildGuideComponent } from './components/build-guide/build-guide.component';
import { CalorieComponent } from './components/calorie/calorie.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { PostComponent } from './components/post/post.component';
import { ProfileComponent } from './components/Profile Folder/profile/profile.component';
import { ProfilesComponent } from './components/Profile Folder/profiles/profiles.component';
import { ProfileSearchComponent } from './components/Profile Folder/profile-search/profile-search.component';
import { EditProfileComponent } from './components/Profile Folder/edit-profile/edit-profile.component';
import { SignupComponent } from './components/signup/signup.component';
import { UploadComponent } from './components/upload/upload.component';
import { UserprofileComponent } from './components/userprofile/userprofile.component';


const routes: Routes = [
  { path:'', component: HomeComponent },
  { path:'user/:id', component: ProfileComponent  },
  { path:'users', component: ProfilesComponent  },
  { path: 'users/search/:id', component: ProfileSearchComponent  },
  { path: 'user/edit/:id' , component: EditProfileComponent  },
  { path: 'signup', component: SignupComponent },
  { path: 'calorietracker', component: CalorieComponent },
  { path: 'build-guide', component: BuildGuideComponent },
  { path: 'login', component: LoginComponent },
  { path: 'post', component: PostComponent },
  { path: 'upload', component: UploadComponent },
  { path: 'userprofile', component: UserprofileComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
