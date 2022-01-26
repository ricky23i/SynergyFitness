import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BuildGuideComponent } from './components/build-guide/build-guide.component';
import { CalorieComponent } from './components/calorie/calorie.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { PostComponent } from './components/post/post.component';
import { ProfileComponent } from './components/profile/profile.component';
import { SignupComponent } from './components/signup/signup.component';
import { UploadComponent } from './components/upload/upload.component';

const routes: Routes = [
  { path:'', component: HomeComponent },
  { path:'user', component: ProfileComponent  },
  { path: 'signup', component: SignupComponent },
  { path: 'calorietracker', component: CalorieComponent },
  { path: 'build-guide', component: BuildGuideComponent },
  { path: 'login', component: LoginComponent },
  { path: 'post', component: PostComponent },
  { path: 'upload', component: UploadComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
