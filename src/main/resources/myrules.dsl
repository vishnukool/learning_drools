[condition][when]Account balance is less than {balance}=$account : Account( balance < {balance} )
[condition][when]Account is of type {account_type:ENUM:Account.getTypes}=$account : Account( type = {account_type} )
[consequence][then]Print Warning = System.out.println("Warning! money running out, put some in ur account");