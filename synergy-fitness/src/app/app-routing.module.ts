import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BuildGuideComponent } from './components/build-guide/build-guide.component';
import { CalorieComponent } from './components/calorie/calorie.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { PostComponent } from './components/post/post.component';
import { ProfileComponent } from './components/profile/profile.component';
import { ProfilesComponent } from './components/profiles/profiles.component';
import { ProfileSearchComponent } from './components/profile-search/profile-search.component';
import { SignupComponent } from './components/signup/signup.component';
import { UploadComponent } from './components/upload/upload.component';
import { UserprofileComponent } from './components/userprofile/userprofile.component';
import { CreatePostComponent } from './tools/create-post/create-post.component';


const routes: Routes = [
  { path:'', component: HomeComponent },
  { path:'user/:id', component: ProfileComponent  },
  { path:'users', component: ProfilesComponent  },
  { path: 'users/search/:id', component: ProfileSearchComponent  },
  { path: 'signup', component: SignupComponent },
  { path: 'calorietracker', component: CalorieComponent },
  { path: 'build-guide', component: BuildGuideComponent },
  { path: 'login', component: LoginComponent },
  { path: 'post', component: PostComponent },
  { path: 'upload', component: UploadComponent },
  { path: 'userprofile', component: UserprofileComponent },
  { path: 'userprofile', component: UserprofileComponent },
  { path: 'createpost', component: CreatePostComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
