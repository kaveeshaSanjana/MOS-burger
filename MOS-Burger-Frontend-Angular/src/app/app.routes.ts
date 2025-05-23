import { Routes } from '@angular/router';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { ProductComponent } from './pages/product/product.component';
import { OrderComponent } from './pages/order/order.component';
import { UpdateOrderComponent } from './pages/order/update-order/update-order.component';
import { CustomerComponent } from './pages/customer/customer.component';
import { CreateProductComponent } from './pages/product/create-product/create-product.component';
import { CreateCustomerComponent } from './pages/customer/create-customer/create-customer.component';
import { UpdateCustomerComponent } from './pages/customer/update-customer/update-customer.component';
import { ProductViewComponent } from './pages/product-view/product-view.component';
import { LoginComponent } from './pages/dashboard/login-routs/login/login.component';
import { VeiwCustomerComponent } from './pages/customer/veiw-customer/veiw-customer.component';
import { LoginRoutsComponent } from './pages/dashboard/login-routs/login-routs.component';

export const routes: Routes = [
    {
        path:'',
        component:LoginComponent
    },
    {
        path:'dashboard',
        component:DashboardComponent
    },
    {
        path:'product',
        component:ProductComponent,
        children:[ 
        {
            path:"product/add",
            component:CreateProductComponent
        },
        {
            path:"product/get-all",
            component:ProductViewComponent
        }]
    },
    {
        path:'order',
        component:OrderComponent,
        children:[{
            path:'order/update',
            component:UpdateOrderComponent
        }]
    },
    
    {
        path:'customer',
        component:CustomerComponent,
        children:[{
            path:"",
            component: VeiwCustomerComponent
    
        },{
            path:"add",
            component: CreateCustomerComponent
    
        },{
            path:"update/:id",
            component: UpdateCustomerComponent
        }]
    },{
        path:'products',
        component:ProductViewComponent
    }]
