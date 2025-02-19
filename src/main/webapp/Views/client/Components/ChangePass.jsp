
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style>
.divider:after,
.divider:before {
content: "";
flex: 1;
height: 1px;
background: #eee;
}
.h-custom {
height: calc(100% - 73px);
}
@media (max-width: 450px) {
.h-custom {
height: 100%;
}
}
</style>

<section class="bg-light py-5">
	<div class="container px-5">
		<div class="row gx-5 justify-content-center">
			<div class="col-xxl-12">
				<div class=" my-5">
					<h2 class="display-5 fw-bolder text-center">
						<span class="text-gradient d-inline">Login Now !</span>
					</h2>
					<section class="vh-100">
						<div class="container-fluid h-custom">
							<div
								class="row d-flex justify-content-center align-items-center h-100">
								<div class="col-md-9 col-lg-6 col-xl-5">
									<img
										src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
										class="img-fluid" alt="Sample image">
								</div>
								<div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
									<form>
										

										<div class="divider d-flex align-items-center my-4">
											<p class="text-center fw-bold fs-3 mx-3 mb-0">ChangePassword Here !</p>
										</div>

										<!-- Email input -->
										<div class="form-outline mb-4">
											<input type="email" id="form3Example3"
												class="form-control form-control-lg"
												placeholder="Enter a valid email address" /> <label
												class="form-label" for="form3Example3">Current Password</label>
										</div>

										<!-- Password input -->
										<div class="form-outline mb-3">
											<input type="password" id="form3Example4"
												class="form-control form-control-lg"
												placeholder="Enter password" /> <label class="form-label"
												for="form3Example4">New Password</label>
										</div>
										<div class="form-outline mb-3">
											<input type="password" id="form3Example4"
												class="form-control form-control-lg"
												placeholder="Enter password" /> <label class="form-label"
												for="form3Example4">Confirm Password</label>
										</div>

										<div class="d-flex justify-content-between align-items-center">
											<!-- Checkbox -->
											<div class="form-check mb-0">
												<input class="form-check-input me-2" type="checkbox"
													value="" id="form2Example3" /> <label
													class="form-check-label" for="form2Example3">
													Remember me </label>
											</div>
											<a href="#!" class="text-body">Forgot password?</a>
										</div>

										<div class="text-center text-lg-start mt-4 pt-2">
											<button type="button" class="btn btn-primary btn-lg"
												style="padding-left: 2.5rem; padding-right: 2.5rem;">ChangePassword</button>
											<p class="small fw-bold mt-2 pt-1 mb-0">
												Don't have an forgotPass? <a href="${pageContext.request.contextPath}/RegisterServlet" class="link-danger">ForgotPass</a>
											</p>
										</div>

									</form>
								</div>
							</div>
						</div>
						
					</section>
				</div>
			</div>
		</div>
	</div>
</section>