package com.goose.week3

trait Planar {
	def height: Int
	def width: Int
	def surface = height * width
}