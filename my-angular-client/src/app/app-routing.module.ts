import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ListComponent } from './board/list/list.component';
import { WriteComponent } from './board/write/write.component';
import { UpdateComponent } from './board/update/update.component';
import { ViewComponent } from './board/view/view.component';

const routes: Routes = [
  { path: '', redirectTo: 'boards', pathMatch: 'full' },
  { path: 'boards', component: ListComponent },
  { path: 'boards/write', component: WriteComponent },
  { path: 'boards/update/:id', component: UpdateComponent },
  { path: 'boards/view/:id', component: ViewComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
