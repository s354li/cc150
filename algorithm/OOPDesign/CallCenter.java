// 2. Imagine you have a call center with three levels of employees: fresher, technical lead (TL), product manager (PM). 
// There can be multiple employees, but only one TL or PM. An incoming telephone call must be allocated to a fresher who is free. 
// If a fresher can’t handle the call, he or she must escalate the call to technical lead. 
// If the TL is not free or not able to handle it, then the call should be escalated to PM. 
// Design the classes and data structures for this problem. Implement a method getCallHandler().
public class Employee {
	public String name;
	public int ID;
	public String address;
	public int rank;
	public boolean free;
	public CallHandler callhandler;
	public Employee(String name, int id, String address, int rank) {
		this.name = name;
		this.ID = id;
		this.address = address;
		this.rank = rank;
		this.free = true;
		this.callhandler = new CallHandler();
	}
	public void ReceiveCall(Call call) {

	}
	public void CallComplete(Call call) {
		free = true;
		call.disconnectCall();
	}
	public void CannotHandle(Call call) {
		call.rank += 1;
		callhandler.dispatchCall(call);
		free = true;
		callhandler.getNextCall();
	}
}
public class Call {
	public int callId;
	public String callMsg;
	public int callStatus;
	public int rank;
	public Call(int id, String msg) {
		this.callId = id;
		this.callMsg = msg;
		this.callStatus = 0;
		this.rank = 0;
	}
	public void startCall(String msg) {
		callStatus = 1;
	}
	public void progressCall(String msg) {

	}
	public void disconnectCall() {
		callStatus = 2;
	}
}
public class CallHandler {
	public Queue<Call> waitingCalls;
	public ArrayList<Employee> allEmployees;
	public CallHandler(int employeeNum) {
		waitingCalls = new Queue<Call>();
		allEmployees = new ArrayList<Employee>();
		allEmployees.add(new TechnicalLead("a", 1, "aa"));
		allEmployees.add(new Manager("b", 2, "bb"));
		allEmployees.add(new Fresher("c", 3, "cc"));
	}
	public Employee getCallHandler(Call call) {
		if (call.rank == 0) {
			for(Employee emp : allEmployees) {
				if (emp.rank == call.rank && emp.free) {
					return emp;
				}
			}
			return null;
		} else {
			boolean freeTL = false;
			if (call.rank == 1) {
				for(Employee emp : allEmployees) {
					if (emp.rank == call.rank && emp.free) {
						freeTL = true;
						return emp;
					}
				}
				if (!freeTL) {
					for(Employee emp : allEmployees) {
						if (emp.rank == call.rank + 1 && emp.free) {
							freeTL = true;
							return emp;
						}
					}
				}
			}
			return null;
		}
	}
	public void dispatchCall(Call call) {
		Employee emp = getCallHandler(call);
		if (emp != null) {
			emp.ReceiveCall(call);
		} else {
			waitingCalls.add(call);
		}
	}
	public Call getNextCall(int rank) {
		Queue<Call> remainCalls = new Queue<Call>();
		if (!waitingCalls.empty()) {
			if (waitingCalls.peek().rank == rank) {
				return waitingCalls.pop();
			} else {
				remainCalls.push(waitingCalls.pop());
			}
		}
		waitingCalls = remainCalls;
		return null;
	}
}
public class Fresher extends Employee {
	public Fresher(String name, int id, String address) {
		super(name, id, address, 0);
	}
	@Override
	public void ReceiveCall(Call call) {
		free = false;
		call.startCall("Fresher message");
	}
}
public class TechnicalLead extends Employee {
	public TechnicalLead(String name, int id, String address) {
		super(name, id, address, 1);
	}
	@Override
	public void ReceiveCall(Call call) {
		free = false;
		call.startCall("Technical lead message");
	}
}
public class Manager extends Employee {
	public Manager(String name, int id, String address) {
		super(name, id, address, 2);
	}
	@Override
	public void ReceiveCall(Call call) {
		free = false;
		call.startCall("Manager message");
	}
}