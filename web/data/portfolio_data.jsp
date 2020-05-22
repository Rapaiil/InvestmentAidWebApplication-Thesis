<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="net-summary">
    <!-- CARD SUMMARY -->
    <div class="card-deck card-summary">
        <div class="card">
            <div class="card-body">
                <h3>&#8369; 2,100 &nbsp; <i class="fas fa-caret-up"></i> <i class="fas fa-caret-down"></i></h3>
                <small class="card-title">Overall Gain/Loss</small> 
            </div>
        </div>
        <div class="card">
            <div class="card-body">
                <h3>1.4% &nbsp; <i class="fas fa-caret-up"></i> <i class="fas fa-caret-down"></i></h3>
                <small class="card-title">Overall Gain/Loss (%)</small> <!-- ((overall market price of shares/units - overall amount invested) / overall amount invested ) * 100 -->
            </div>
        </div>
    </div>
    
    <!-- TOP 5 PERFORMING INVESTMENTS -->
        <div class="card-deck mt-3">
        	<div class="card p-3 text-center mt-3">
            <h4 class="card-title">Top 5 Performing Funds</h4>
            <div class="card-body">
                <ul class="nav nav-pills portfolio-performance pb-3">
                    <li class="nav-item">
                        <a class="nav-link active" href="#perf-mf" data-toggle="tab" role="tab">MF</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#perf-uitf" data-toggle="tab" role="tab">UITF</a>
                    </li>
                </ul>
                
                <div class="tab-content" id="tabperf" class="tab-content" role="tabpanel">
                	<div class="tab-pane fade show active" id="perf-mf">
                		<div class="table-responsive-md top-five-investments">
                   <table class="table table-hover">
                       <thead class="investment-performance-table">
                           <tr>
                               <th scope="col">Fund Name</th>
                               <th scope="col">Fund Classification</th>
                               <th scope="col">Gain/Loss (%)</th>
                           </tr>
                       </thead>
                       <tbody>
                           <tr>
                               <td></td>
                               <td></td>
                               <td>% &nbsp; <i class="fas fa-caret-up"></i> <i class="fas fa-caret-down"></i></td>
                           </tr>
                       </tbody>
                   </table>
               </div>
                	</div>
                	<div class="tab-pane fade" id="perf-uitf">
                		<div class="table-responsive-md top-five-investments">
                   <table class="table table-hover">
                       <thead class="investment-performance-table">
                           <tr>
                               <th scope="col">Fund Name</th>
                               <th scope="col">Fund Classification</th>
                               <th scope="col">Gain/Loss (%)</th>
                           </tr>
                       </thead>
                       <tbody>
                           <tr>
                               <td></td>
                               <td></td>
                               <td>% &nbsp; <i class="fas fa-caret-up"></i> <i class="fas fa-caret-down"></i></td>
                           </tr>
                       </tbody>
                   </table>
               </div>
                	</div>
                </div>
            </div>
        </div>
        
        <div class="card p-3 text-center mt-3">
            <h4 class="card-title">Worst 5 Performing Funds</h4>
            <div class="card-body">
                <ul class="nav nav-pills .portfolio-performance pb-3">
                     <li class="nav-item">
                         <a class="nav-link active" href="#worst-mf" data-toggle="tab" role="tab">MF</a>
                     </li>
                     <li class="nav-item">
                         <a class="nav-link" href="#worst-uitf" data-toggle="tab" role="tab">UITF</a>
                     </li>
                 </ul>
                 
                 <div class="tab-content" id="tabperf" class="tab-content" role="tabpanel">
                 	<div class="tab-pane fade show active" id="worst-mf">
                 		<div class="table-responsive-md top-five-investments">
                    <table class="table table-hover">
                        <thead class="investment-performance-table">
                            <tr>
                               <th scope="col">Fund Name</th>
                               <th scope="col">Fund Classification</th>
                               <th scope="col">Gain/Loss (%)</th>
                           </tr>
                       </thead>
                        <tbody>
                            <tr>
                                <td></td>
                                <td></td>
                                <td>% &nbsp; <i class="fas fa-caret-up"></i> <i class="fas fa-caret-down"></i></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                 	</div>
                 	<div class="tab-pane fade" id="worst-uitf">
                 		<div class="table-responsive-md top-five-investments">
                    <table class="table table-hover">
                        <thead class="investment-performance-table">
                            <tr>
                               <th scope="col">Fund Name</th>
                               <th scope="col">Fund Classification</th>
                               <th scope="col">Gain/Loss (%)</th>
                           </tr>
                       </thead>
                        <tbody>
                            <tr>
                                <td></td>
                                <td></td>
                                <td>% &nbsp; <i class="fas fa-caret-up"></i> <i class="fas fa-caret-down"></i></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                 	</div>
                 </div>
             </div>
         </div>
        </div>
        
        
        <!-- OVERALL GAIN/LOSS TABLE -->
     <div class="card mt-3">
     	<div class="card-body">
             <h3>Overall Gain/Loss</h3>
             <div class="table-responsive-md top-five-investments">
                 <table id="overall" class="display table table-hover table-striped">
                     <thead class="investment-performance-table">
                         <tr>
                             <th scope="col">Fund Name</th>
                             <th scope="col">Fund Classification</th>
                             <th scope="col">Amount</th>
                             <th scope="col">Current NAVPU/NAVPS</th>
                             <th scope="col">No. Shares/Units</th>
                             <th scope="col">Current Market Price</th>
                             <th scope="col">Gain/Loss (%)</th>
                         </tr>
                     </thead>
                     <tbody>
                         <tr>
                             <td></td>
                             <td></td>
                             <td></td>
                             <td></td>
                             <td></td>
                             <td></td>
                             <td>% &nbsp; <i class="fas fa-caret-up"></i> <i class="fas fa-caret-down"></i></td>
                         </tr>
                     </tbody>
                 </table>
             </div>
         </div>
     </div>
    <!-- GRAPHS -->
    <div class="card-deck mt-3">
        <!-- LINE GRAPH/PORTFOLIO PERFORMANCE -->
        <div class="card p-3 text-center">
            <h4 class="card-title">Portfolio Performance</h4>
            <div class="card-body">
                <ul class="nav nav-pills .portfolio-performance pb-3">
                    <li class="nav-item">
                        <a class="nav-link active" href="#">Today</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Week</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Month</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">1Y</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">3Y</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">5Y</a>
                    </li>
                </ul>
                <canvas id="lineGraphPerformance" width="400" height="400"></canvas>
            </div>
        </div>
        <!-- ASSET ALLOCATION -->
            <div class="card p-3 text-center">
                <h4 class="card-title">Portfolio Allocation</h4>
                <div class="card-body">
                    <canvas id="doughnutGraphAsset" width="400" height="400"></canvas>
                </div>
            </div>
        </div>
    </div>
</div>