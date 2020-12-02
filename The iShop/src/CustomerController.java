public class CustomerController {
   private ShoppingQueue model;
   private CustomerView view;
   private CustomerView2 view2;

   public CustomerController(ShoppingQueue model, CustomerView view, CustomerView2 view2){
      this.model = model;
      this.view = view;
      this.view2 = view2;
   }

   public void setCustomer(Customer customer) throws InterruptedException{
      model.addNewCustomer(customer);		
   }

   public void updateCustomerView(){			
      view.printCustomerDetails(model.customer.getID(),model.customer.getBasket());
   }
   
   public void updateQueueView(){				
	   	  view2.printQueues(ShoppingQueue.getQueue0(),ShoppingQueue.getQueue1(), ShoppingQueue.getQueue2());
	   }
}