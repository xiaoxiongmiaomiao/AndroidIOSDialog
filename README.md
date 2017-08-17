# AndroidIOSDialog
自定义的Dialog,完美仿照Dialog


final AlertCustom alertCustom = new AlertCustom(MainActivity.this);
			        alertCustom.setAlertTitle("title");
			        alertCustom.setAlertContent("This is content,you may be repair content ");
			        alertCustom.showAlertCustom(new AlertCustom.DialogClick() {
			            @Override
			            public void alertClickOk(boolean click) {
			                if (click) {
			                    alertCustom.dismissAlert();
			                    System.out.println("close");
			                } else {
			                	System.out.println("Open");
			                    alertCustom.dismissAlert();
			                }
			            }
			        });
